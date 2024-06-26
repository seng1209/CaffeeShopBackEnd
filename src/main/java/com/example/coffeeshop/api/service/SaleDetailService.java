package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.sale_detail.CreateSaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.SaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.UpdateSaleDetailDto;

import java.math.BigDecimal;
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

}
