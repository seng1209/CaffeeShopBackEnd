package com.example.coffeeshop.api.web.sale;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateTotalAmountSaleDto(
        @Positive(message = "Total Amount must be Integer number and large than 0!")
        BigDecimal totalAmount
) {
}
