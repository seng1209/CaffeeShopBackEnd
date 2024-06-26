package com.example.coffeeshop.api.web.order;

import jakarta.validation.constraints.Positive;

public record UpdateOrderDto(
        @Positive(message = "Customer ID must be Integer number and large than 0.")
        Integer customerId
//        @Positive(message = "Quantity must be Integer number and large than 0.")
//        Integer quantity
) {
}
