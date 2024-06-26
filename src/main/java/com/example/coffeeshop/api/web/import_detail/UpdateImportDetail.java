package com.example.coffeeshop.api.web.import_detail;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateImportDetail(
        @Positive(message = "Import ID must be Integer number and large than 0!")
        Long importId,
        @Positive(message = "Item ID must be Integer number and large than 0!")
        Integer itemId,
        @Positive(message = "Import Quantity must be Integer number and large than 0!")
        Integer importQty,
        @Positive(message = "Unit Price must be Integer number and large than 0!")
        BigDecimal unitPrice
) {
}
