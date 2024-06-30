package com.example.coffeeshop.api.web.invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceDto(
        @JsonIgnore
        Long id,
        String uuid,
        LocalDate invoiceDate,
        BigDecimal totalAmount,
//        BigDecimal paidAmount,
        String customer) {
    public Long getId(){
        return this.id();
    }
}
