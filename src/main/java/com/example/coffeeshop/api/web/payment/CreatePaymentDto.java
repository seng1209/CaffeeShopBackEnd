package com.example.coffeeshop.api.web.payment;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreatePaymentDto(
        @Positive(message = "CustomerID must be required and lager than 0!....")
        Integer customerId,
        @Positive(message = "StaffID must be required and lager than 0!....")
        Long staffId,
        @Positive(message = "Paid Amount must be required and lager than 0!....")
        BigDecimal paidAmount
) {
}
