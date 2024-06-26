package com.example.coffeeshop.api.web.imports;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateImportDto(
        @Positive(message = "Staff ID must be Integer number and large than 0!")
        Long staffId,
        @Positive(message = "Supplier ID must be Integer number and large than 0!")
        Integer supplierId
) {
}
