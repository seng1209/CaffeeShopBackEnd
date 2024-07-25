package com.example.coffeeshop.api.web.delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateDeliveryDto(
        @NotBlank(message = "Address must be required!")
        String address
) {
}
