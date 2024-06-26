package com.example.coffeeshop.api.web.supllier;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record SupplierDto(
        @JsonIgnore
        Integer id,
        String name,
        String contactPhone,
        String contactAddress) {

    public Integer getId(){
        return this.id();
    }

}
