package com.example.coffeeshop.api.web.imports;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ImportDto(
        @JsonIgnore
        Long id,
        String uuid,
        LocalDate importDate,
        @JsonIgnore
        Integer staffId,
        String staff,
        @JsonIgnore
        Integer supplierId,
        String supplier,
        BigDecimal totalAmount,
        Boolean isDelete) {

        public Long getId(){
                return this.id();
        }

        public Integer getStaffId(){
                return this.staffId();
        }

        public Integer getSupplierId(){
                return this.supplierId();
        }
}