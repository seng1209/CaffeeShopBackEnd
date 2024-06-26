package com.example.coffeeshop.api.web.sale;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateSaleDto(
        @NotNull(message = "Customer ID must be required!")
        @Positive(message = "Customer ID must be Integer number and large than 0!")
        Integer customerId,
        @NotNull(message = "Staff ID must be required!")
        @Positive(message = "Staff ID must be Integer number and large than 0!")
        Long staffId
//        @NotNull(message = "Total Amount must be required!")
//        @Positive(message = "Total Amount must be Integer number and large than 0!")
//        BigDecimal totalAmount
) {
}
