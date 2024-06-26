package com.example.coffeeshop.api.web.import_detail;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record ImportDetailDto(
        @JsonIgnore
        Long id,
        String uuid,
        @JsonIgnore
        Long importId,
        String imports,
        @JsonIgnore
        Integer itemId,
        String items,
        Integer importQty,
        BigDecimal unitPrice,
        BigDecimal amount
) {

    public Long getId(){
        return this.id();
    }

    public Long getImportsId(){
        return this.importId();
    }

    public Integer getItemsId(){
        return this.itemId();
    }
}
