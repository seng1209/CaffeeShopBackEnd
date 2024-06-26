package com.example.coffeeshop.api.web.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record ProductDto(
        @JsonIgnore
        Integer id,
        String image,
        String name,
        BigDecimal saleUnitPrice,
        String description,
        @JsonIgnore
        Integer categoryId,
        String category) {

    public Integer getId(){
        return this.id();
    }

    public Integer getCategoryId(){
        return this.categoryId();
    }
}
