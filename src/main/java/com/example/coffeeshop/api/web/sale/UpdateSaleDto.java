package com.example.coffeeshop.api.web.sale;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateSaleDto(
        @Positive(message = "Customer ID must be Integer number and large than 0!")
        Integer customerId,
        @Positive(message = "Staff ID must be Integer number and large than 0!")
        Long staffId,
        @Positive(message = "Payment ID must be Integer number and large than 0!")
        Long paymentId,
        @Positive(message = "Delivery ID must be Integer number and large than 0!")
        Long deliveryId
//        @Positive(message = "Total Amount must be Integer number and large than 0!")
//        BigDecimal totalAmount
) {
}
