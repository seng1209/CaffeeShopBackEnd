package com.example.coffeeshop.api.web.sale_detail;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateSaleDetailDto(
        @Positive(message = "Sale ID must be Integer number and large than 0!")
        Long saleId,
        @Positive(message = "Product ID must be Integer number and large than 0!")
        Integer productId,
        @Positive(message = "Sale Quantity must be Integer number and large than 0!")
        Integer saleQty,
        @Positive(message = "Sale Unit Price must be Integer number and large than 0!")
        BigDecimal saleUnitPrice,
//        @Positive(message = "must be Integer number!")
        BigDecimal discount
) {
}
