package com.example.coffeeshop.api.web.sale_detail;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record SaleDetailDto(
        @JsonIgnore
        Long id,
        String uuid,
        @JsonIgnore
        Long saleId,
        String sale,
        @JsonIgnore
        Integer productId,
        String product,
        Integer saleQty,
        BigDecimal saleUnitPrice,
        BigDecimal discount,
        BigDecimal amount
) {

    public Long getId(){
        return this.id();
    }

    public Long getSaleId(){
        return this.saleId();
    }

    public Integer getProductId(){
        return this.productId();
    }
}
