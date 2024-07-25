package com.example.coffeeshop.api.web.sale_detail;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SaleDetailDto(
        @JsonIgnore
        Long id,
        String uuid,
        @JsonIgnore
        Long saleId,
        String sale,
        LocalDate saleDate,
        @JsonIgnore
        Integer productId,
        String product,
        Integer saleQty,
        BigDecimal saleUnitPrice,
        BigDecimal discount,
        BigDecimal amount,
        String staff,
        String staffPosition,
        String customer,
        Integer customerId,
        String customerPhone,
        String customerType
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
