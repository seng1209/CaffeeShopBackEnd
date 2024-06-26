package com.example.coffeeshop.api.web.order_detail;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateOrderDetailDto(
        @Positive(message = "Order ID must be Integer number and large than 0!")
        Long orderId,
        @Positive(message = "Product ID must be Integer number and large than 0!")
        Integer productId,
        @Positive(message = "Unit Price must be Integer number and large than 0!")
        BigDecimal unitPrice,
        @Positive(message = "Quantity must be Integer number and large than 0!")
        Integer quantity
) {
}
