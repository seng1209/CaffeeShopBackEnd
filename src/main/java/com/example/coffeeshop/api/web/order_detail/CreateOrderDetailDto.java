package com.example.coffeeshop.api.web.order_detail;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateOrderDetailDto(
        @NotNull(message = "Order ID must be required!")
        @Positive(message = "Order ID must be Integer number and large than 0!")
        Long orderId,
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
