package com.example.coffeeshop.api.web.import_detail;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ImportReportDto(
        String staff,
        String staffPosition,
        String supplier,
        String supplierContactPhone,
        Long importId,
        LocalDate importDate,
        String items,
        Integer importQty,
        BigDecimal unitPrice,
        BigDecimal amount
) {
}
