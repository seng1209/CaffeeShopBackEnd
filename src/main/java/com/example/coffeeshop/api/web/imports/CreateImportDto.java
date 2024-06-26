package com.example.coffeeshop.api.web.imports;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateImportDto(
        @NotNull(message = "Staff ID must be required!")
        @Positive(message = "Staff ID must be Integer number and large than 0!")
        Long staffId,
        @NotNull(message = "Supplier ID must be required!")
        @Positive(message = "Supplier ID must be Integer number and large than 0!")
        Integer supplierId
//        @NotNull(message = "Total Amount must be required!")
//        @Positive(message = "Total Amount must be Integer number and large than 0!")
//        BigDecimal totalAmount
) {
}
