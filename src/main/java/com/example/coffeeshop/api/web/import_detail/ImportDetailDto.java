package com.example.coffeeshop.api.web.import_detail;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ImportDetailDto(
        @JsonIgnore
        Long id,
        String uuid,
        @JsonIgnore
        Long importId,
        String imports,
        LocalDate importDate,
        @JsonIgnore
        Integer itemId,
        String items,
        Integer importQty,
        BigDecimal unitPrice,
        BigDecimal amount,
        String staff,
        String staffPosition,
        String supplier,
        String supplierContactPhone
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
