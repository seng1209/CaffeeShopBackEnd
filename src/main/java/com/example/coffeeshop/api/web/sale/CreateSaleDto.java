package com.example.coffeeshop.api.web.sale;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateSaleDto(
        @NotNull(message = "Customer ID must be required!")
        @Positive(message = "Customer ID must be Integer number and large than 0!")
        Integer customerId,
        @NotNull(message = "Staff ID must be required!")
        @Positive(message = "Staff ID must be Integer number and large than 0!")
        Long staffId,
        @NotNull(message = "Payment ID must be required!")
        @Positive(message = "Payment ID must be Integer number and large than 0!")
        Long paymentId,
        @Positive(message = "Delivery ID must be Integer number and large than 0!")
        Long deliveryId
) {
}
