package com.example.coffeeshop.api.web.payment;

import java.math.BigDecimal;

public record UpdatePaidAmountPaymentDto(
        BigDecimal paidAmount
) {
}
