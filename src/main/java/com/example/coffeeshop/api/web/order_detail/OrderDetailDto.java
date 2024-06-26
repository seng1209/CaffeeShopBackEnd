package com.example.coffeeshop.api.web.order_detail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Lob;

import java.math.BigDecimal;

public record OrderDetailDto(
        @JsonIgnore
        Long id,
        String uuid,
        @JsonIgnore
        Long orderId,
        String order,
        @JsonIgnore
        Integer productId,
        String product,
        BigDecimal unitPrice,
        Integer quantity
//        BigDecimal amount
) {

    public Long getId(){
        return this.id();
    }

    public Long getOrderId(){
        return this.orderId();
    }

    public Integer getProductId(){
        return this.productId();
    }
}
