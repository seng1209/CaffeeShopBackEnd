package com.example.coffeeshop.api.web.invoice_detail;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public record InvoiceDetailDto(
        @JsonIgnore
        Long id,
        String uuid,
        @JsonIgnore
        Long invoiceId,
        String invoice,
        @JsonIgnore
        Integer productId,
        String product,
        BigDecimal unitPrice,
        Integer quantity,
        BigDecimal productTotal,
        Boolean isDeleted
        ) {

    public Long getId(){
        return this.id();
    }

    public Long getInvoiceId(){
        return this.invoiceId();
    }

    public Integer getProductId(){
        return this.productId();
    }
}
