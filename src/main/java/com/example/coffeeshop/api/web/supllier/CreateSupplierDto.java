package com.example.coffeeshop.api.web.supllier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSupplierDto(
        @NotBlank(message = "Phone must be required!")
        String name,
        @NotBlank(message = "Contact Phone must be required!")
        @Size(max = 20)
        String contactPhone,
        @NotBlank(message = "Contact Address must be required!")
        String contactAddress
) {
}
