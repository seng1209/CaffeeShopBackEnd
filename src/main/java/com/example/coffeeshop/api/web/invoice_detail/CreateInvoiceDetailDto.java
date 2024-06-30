package com.example.coffeeshop.api.web.invoice_detail;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateInvoiceDetailDto(
        @NotNull(message = "Invoice ID must be required!")
        @Positive(message = "Invoice ID must be Integer number and large than 0!")
        Long invoiceId,
        @NotNull(message = "Product ID must be required!")
        @Positive(message = "Product ID must be Integer number and large than 0!")
        Integer productId,
        @NotNull(message = "Unit Price must be required!")
        @Positive(message = "Unit Price must be Integer number and large than 0!")
        BigDecimal unitPrice,
        @NotNull(message = "Quantity must be required!")
        @Positive(message = "Quantity must be Integer number and large than 0!")
        Integer quantity
) {
}
