package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Customer;
import com.example.coffeeshop.api.entities.Sale;
import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.mapper.SaleMapper;
import com.example.coffeeshop.api.repository.SaleRepository;
import com.example.coffeeshop.api.web.sale.CreateSaleDto;
import com.example.coffeeshop.api.web.sale.SaleDto;
import com.example.coffeeshop.api.web.sale.UpdateSaleDto;
import com.example.coffeeshop.api.web.sale.UpdateTotalAmountSaleDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleServiceImplement implements SaleService{

    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;

    @Override
    public void createNewSale(CreateSaleDto createSaleDto) {
        Sale sale = saleMapper.fromSaleDto(createSaleDto);
        sale.setUuid(UUID.randomUUID().toString());
        sale.setSaleDate(LocalDate.now());
        sale.setTotalAmount(BigDecimal.valueOf(0));
        saleRepository.save(sale);
    }

    @Override
    public void updateSaleByUuid(String uuid, UpdateSaleDto updateSaleDto) {
        if (saleRepository.existsByUuid(uuid)){
            Sale sale = saleRepository.findByUuid(uuid).orElseThrow();
            saleMapper.fromUpdateSaleDto(sale, updateSaleDto);

            if (updateSaleDto.customerId() != null){
                Customer newCustomer = new Customer();
                newCustomer.setId(updateSaleDto.customerId());
                sale.setCustomer(newCustomer);
            }

            if (updateSaleDto.staffId() != null){
                Staff newStaff = new Staff();
                newStaff.setId(updateSaleDto.staffId());
                sale.setStaff(newStaff);
            }

            saleRepository.save(sale);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteSaleByUuid(String uuid) {
        if (saleRepository.existsByUuid(uuid)){
            Sale sale = saleRepository.findByUuid(uuid).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Sale at UUID : %s is not found...!", uuid))
            );

            saleRepository.delete(sale);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteAllSaleBySaleDate(LocalDate date) {
        if (saleRepository.existsBySaleDate(date)){
            List<Sale> sales = saleRepository.findAllBySaleDate(date);
            saleRepository.deleteAll(sales);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale at Date : %s is not found...!", date));
    }

    @Override
    public SaleDto findByUuid(String uuid) {
        Sale sale = saleRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale at UUID : %s is not found...!", uuid))
        );
        return saleMapper.toSaleDto(sale);
    }

    @Override
    public List<SaleDto> findALl() {
        List<Sale> sales = saleRepository.findAll();
        return saleMapper.toSaleDtoList(sales);
    }

    @Override
    public Long getLastSaleId() {
        return saleRepository.getLastSaleId();
    }

    @Transactional
    @Override
    public void updateTotalAmountBySaleId(Long saleId, UpdateTotalAmountSaleDto updateTotalAmountSaleDto) {
        saleRepository.editTotalAmountBySaleId(saleId, updateTotalAmountSaleDto.totalAmount());
    }
}
