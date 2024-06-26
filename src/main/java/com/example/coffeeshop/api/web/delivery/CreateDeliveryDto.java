package com.example.coffeeshop.api.web.delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateDeliveryDto(
        @NotBlank(message = "Address must be required!")
        String address,
        @NotNull(message = "Order ID must be required!")
        @Positive(message = "Order ID must be Integer number and large than 0!")
        Long orderId
) {
}
