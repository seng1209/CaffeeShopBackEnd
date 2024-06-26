package com.example.coffeeshop.api.web.delivery;

import jakarta.validation.constraints.Positive;

public record UpdateDeliveryDto(
        String address,
        @Positive(message = "Order ID must be Integer number and large than 0!")
        Long orderId
) {
}
