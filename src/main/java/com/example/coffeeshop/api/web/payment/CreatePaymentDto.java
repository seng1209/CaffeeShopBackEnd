package com.example.coffeeshop.api.web.payment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreatePaymentDto(
        @NotNull(message = "Customer ID must be required!")
        @Positive(message = "CustomerID must be required and lager than 0!....")
        Integer customerId,
        @NotNull(message = "Staff ID must be required!")
        @Positive(message = "Staff ID must be required and lager than 0!....")
        Long staffId
//        @Positive(message = "Paid Amount must be required and lager than 0!....")
//        BigDecimal paidAmount
) {
}
