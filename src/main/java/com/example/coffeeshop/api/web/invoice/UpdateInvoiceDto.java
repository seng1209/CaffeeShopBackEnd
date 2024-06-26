package com.example.coffeeshop.api.web.invoice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateInvoiceDto(
        @Positive(message = "Total Amount must be Integer number and large than 0!")
        BigDecimal totalAmount,
        @Positive(message = "Paid Amount must be Integer number and large than 0!")
        BigDecimal paidAmount,
        @Positive(message = "Customer must be Integer number and large than 0!")
        Integer customerId
) {
}
