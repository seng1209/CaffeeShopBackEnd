package com.example.coffeeshop.api.web.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderDto(
        @NotNull(message = "Customer ID must be required!")
        @Positive(message = "Customer ID must be Integer number and large than 0.")
        Integer customerId
//        @NotNull(message = "Quantity must be required!")
//        @Positive(message = "Quantity must be Integer number and large than 0.")
//        Integer quantity
) {
}
