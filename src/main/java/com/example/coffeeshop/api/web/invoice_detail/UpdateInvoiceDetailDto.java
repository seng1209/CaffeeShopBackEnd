package com.example.coffeeshop.api.web.invoice_detail;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateInvoiceDetailDto(
        @Positive(message = "Invoice ID must be Integer number and large than 0!")
        Long invoiceId,
        @Positive(message = "Product ID must be Integer number and large than 0!")
        Integer productId,
        @Positive(message = "Unit Price must be Integer number and large than 0!")
        BigDecimal unitPrice,
        @Positive(message = "Quantity must be Integer number and large than 0!")
        Integer quantity
) {
}
