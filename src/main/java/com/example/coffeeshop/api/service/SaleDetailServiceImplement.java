package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Product;
import com.example.coffeeshop.api.entities.Sale;
import com.example.coffeeshop.api.entities.SaleDetail;
import com.example.coffeeshop.api.mapper.SaleDetailMapper;
import com.example.coffeeshop.api.repository.SaleDetailRepository;
import com.example.coffeeshop.api.web.product.ProductDto;
import com.example.coffeeshop.api.web.sale_detail.CreateSaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.SaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.UpdateSaleDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleDetailServiceImplement implements SaleDetailService{

    private final SaleDetailMapper saleDetailMapper;
    private final SaleDetailRepository saleDetailRepository;

    @Override
    public void createNewSaleDetail(CreateSaleDetailDto createSaleDetailDto) {
        SaleDetail saleDetail = saleDetailMapper.fromSaleDetailDto(createSaleDetailDto);
        saleDetail.setUuid(UUID.randomUUID().toString());
        saleDetail.setAmount((createSaleDetailDto.saleUnitPrice().multiply(BigDecimal.valueOf(createSaleDetailDto.saleQty()))).subtract(createSaleDetailDto.discount()));
        saleDetailRepository.save(saleDetail);
    }

    @Override
    public void updateByUuid(String uuid, UpdateSaleDetailDto updateSaleDetailDto) {
        if (saleDetailRepository.existsByUuid(uuid)){
            SaleDetail saleDetail = saleDetailRepository.findByUuid(uuid).orElseThrow();
            saleDetailMapper.fromUpdateSaleDetailDto(saleDetail, updateSaleDetailDto);

            if (updateSaleDetailDto.saleId() != null){
                Sale newSale = new Sale();
                newSale.setId(updateSaleDetailDto.saleId());
                saleDetail.setSale(newSale);
            }

            if (updateSaleDetailDto.productId() != null){
                Product newProduct = new Product();
                newProduct.setId(updateSaleDetailDto.productId());
                saleDetail.setProduct(newProduct);
            }
            saleDetail.setAmount((updateSaleDetailDto.saleUnitPrice().multiply(BigDecimal.valueOf(updateSaleDetailDto.saleQty()))).subtract(updateSaleDetailDto.discount()));
            saleDetailRepository.save(saleDetail);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale Detail at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        SaleDetail saleDetail = saleDetailRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale Detail at UUID : %s is not found...!", uuid))
        );

        saleDetailRepository.delete(saleDetail);
    }

    @Override
    public SaleDetailDto findByUuid(String uuid) {
        SaleDetail saleDetail = saleDetailRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Sale Detail at UUID : %s is not found...!", uuid))
        );
        return saleDetailMapper.toSaleDetailDto(saleDetail);
    }

    @Override
    public List<SaleDetailDto> findAll() {
        List<SaleDetail> saleDetails = saleDetailRepository.findAll();
        return saleDetailMapper.toSaleDetailDtoList(saleDetails);
    }

    @Override
    public BigDecimal getAllAmountBySaleId(Long saleId) {
        return saleDetailRepository.sumAllAmountOfSaleDetailBySaleId(saleId);
    }

    @Override
    public BigDecimal getAmountBySaleDate(LocalDate date) {
        return saleDetailRepository.sumAllAmountOfSaleDetailBySaleDate(date);
    }

    @Override
    public BigDecimal getAmountBetweenDate(LocalDate firstDate, LocalDate lastDate) {
        return saleDetailRepository.sumAllAmountOfSaleDetailBetweenSaleDate(firstDate, lastDate);
    }

    @Override
    public List<SaleDetailDto> findAllSaleDetailBySaleUuid(String uuid) {
        List<SaleDetail> saleDetails = saleDetailRepository.getAllSaleDetailBySaleUuid(uuid);
        return saleDetailMapper.toSaleDetailDtoList(saleDetails);
    }

    @Override
    public List<SaleDetailDto> findAllSaleDetailBySaleId(Long saleId) {
        List<SaleDetail> saleDetails = saleDetailRepository.getAllSaleDetailBySaleId(saleId);
        return saleDetailMapper.toSaleDetailDtoList(saleDetails);
    }

    @Override
    public List<SaleDetailDto> findAllSaleDetailBySaleDate(LocalDate date) {
        List<SaleDetail> saleDetails = saleDetailRepository.getAllBySaleDate(date);
        return saleDetailMapper.toSaleDetailDtoList(saleDetails);
    }

    @Override
    public List<SaleDetailDto> findAllSaleDetailBetweenSaleDate(LocalDate firstDate, LocalDate lastDate) {
        List<SaleDetail> saleDetails = saleDetailRepository.getAllByBetweenDate(firstDate, lastDate);
        return saleDetailMapper.toSaleDetailDtoList(saleDetails);
    }
}
