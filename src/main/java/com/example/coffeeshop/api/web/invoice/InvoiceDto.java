package com.example.coffeeshop.api.web.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceDto(
        String uuid,
        LocalDate invoiceDate,
        BigDecimal totalAmount,
        BigDecimal paidAmount,
        String customer) {
}
