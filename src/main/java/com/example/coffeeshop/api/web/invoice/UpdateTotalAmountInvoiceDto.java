package com.example.coffeeshop.api.web.invoice;

import java.math.BigDecimal;

public record UpdateTotalAmountInvoiceDto(
        BigDecimal totalAmount
) {
}
