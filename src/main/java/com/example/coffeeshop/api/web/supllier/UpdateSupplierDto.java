package com.example.coffeeshop.api.web.supllier;

import jakarta.validation.constraints.Size;

public record UpdateSupplierDto(
        String name,
        @Size(max = 20, message = "Contact Phone length 20!")
        String contactPhone,
        String contactAddress
) {
}
