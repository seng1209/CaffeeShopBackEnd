package com.example.coffeeshop.api.web.invoice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateInvoiceDto(
        @NotNull(message = "Total Amount must be required!")
        @Positive(message = "Total Amount must be Integer number and large than 0!")
        BigDecimal totalAmount,
        @NotNull(message = "Paid Amount must be required!")
        @Positive(message = "Paid Amount must be Integer number and large than 0!")
        BigDecimal paidAmount,
        @NotNull(message = "Customer must be required!")
        @Positive(message = "Customer must be Integer number and large than 0!")
        Integer customerId
) {
}
