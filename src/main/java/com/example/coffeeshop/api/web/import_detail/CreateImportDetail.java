package com.example.coffeeshop.api.web.import_detail;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateImportDetail(
        @NotNull(message = "Import ID must be required!")
        @Positive(message = "Import ID must be Integer number and large than 0!")
        Long importId,
        @NotNull(message = "Item ID must be required!")
        @Positive(message = "Item ID must be Integer number and large than 0!")
        Integer itemId,
        @NotNull(message = "Import Quantity must be required!")
        @Positive(message = "Import Quantity must be Integer number and large than 0!")
        Integer importQty,
        @NotNull(message = "Unit Price must be required!")
        @Positive(message = "Unit Price must be Integer number and large than 0!")
        BigDecimal unitPrice
) {
}
