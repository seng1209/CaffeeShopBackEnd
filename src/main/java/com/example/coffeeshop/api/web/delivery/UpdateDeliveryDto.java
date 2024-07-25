package com.example.coffeeshop.api.web.delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UpdateDeliveryDto(
        String address
) {
}
