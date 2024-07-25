package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Sale;
import com.example.coffeeshop.api.web.product.ProductDto;
import com.example.coffeeshop.api.web.sale_detail.CreateSaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.SaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.UpdateSaleDetailDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SaleDetailService {

    // create sale_detail
    void createNewSaleDetail(CreateSaleDetailDto createSaleDetailDto);

    // update sale_detail by uuid
    void updateByUuid(String uuid, UpdateSaleDetailDto updateSaleDetailDto);

    // delete sale_detail by uuid
    void deleteByUuid(String uuid);

    // select sale_detail by uuid
    SaleDetailDto findByUuid(String uuid);

    // select all sale_detail
    List<SaleDetailDto> findAll();

    // get sum of amount of sale_detail by sale_id
    BigDecimal getAllAmountBySaleId(Long saleId);

    // get amount by sale date
    BigDecimal getAmountBySaleDate(LocalDate date);

    // get amount between date
    BigDecimal getAmountBetweenDate(LocalDate firstDate, LocalDate lastDate);

    // get all sale_detail by sale_uuid
    List<SaleDetailDto> findAllSaleDetailBySaleUuid(String uuid);

    // get all sale_detail by sale id
    List<SaleDetailDto> findAllSaleDetailBySaleId(Long saleId);

    // get all sale_detail by sale date
    List<SaleDetailDto> findAllSaleDetailBySaleDate(LocalDate date);

    // get all sale_detail between sale date
    List<SaleDetailDto> findAllSaleDetailBetweenSaleDate(LocalDate firstDate, LocalDate lastDate);

}
