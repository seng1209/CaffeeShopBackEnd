package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.sale.CreateSaleDto;
import com.example.coffeeshop.api.web.sale.SaleDto;
import com.example.coffeeshop.api.web.sale.UpdateSaleDto;
import com.example.coffeeshop.api.web.sale.UpdateTotalAmountSaleDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SaleService {

    // create sale
    void createNewSale(CreateSaleDto createSaleDto);

    // update sale by uuid
    void updateSaleByUuid(String uuid, UpdateSaleDto updateSaleDto);

    // delete by uuid
    void deleteSaleByUuid(String uuid);

    // delete all by sale_date
    void deleteAllSaleBySaleDate(LocalDate date);

    // select by uuid
    SaleDto findByUuid(String uuid);

    // select all
    List<SaleDto> findALl();

    // get last sale_id
    Long getLastSaleId();

    // update total_amount by sale_id
    void updateTotalAmountBySaleId(Long saleId, UpdateTotalAmountSaleDto updateTotalAmountSaleDto);

    BigDecimal getTotalAmountByUuid(Long id);

    // find by sale id
    SaleDto findById(Long id);

    // find by sale date
    List<SaleDto> findBySaleDate(LocalDate date);

    // find by customer name
    List<SaleDto> findAllByCustomer(String customer);

    // find by staff name
    List<SaleDto> findAllByStaff(String staff);

}
