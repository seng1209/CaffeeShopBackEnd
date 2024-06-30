package com.example.coffeeshop.api.web.sale_detail;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateSaleDetailDto(
        @NotNull(message = "Sale ID must be required!")
        @Positive(message = "Sale ID must be Integer number and large than 0!")
        Long saleId,
        @NotNull(message = "Product ID must be required!")
        @Positive(message = "Product ID must be Integer number and large than 0!")
        Integer productId,
        @NotNull(message = "Sale Quantity must be required!")
        @Positive(message = "Sale Quantity must be Integer number and large than 0!")
        Integer saleQty,
        @NotNull(message = "Sale Unit Price must be required!")
        @Positive(message = "Sale Unit Price must be Integer number and large than 0!")
        BigDecimal saleUnitPrice,
//        @Positive(message = "must be Integer number!")
        BigDecimal discount
) {
}
