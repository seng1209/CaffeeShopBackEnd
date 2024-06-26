package com.example.coffeeshop.api.web.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProductDto(
        @NotBlank(message = "Image must be required!")
        String image,
        @NotBlank(message = "Name must be required!")
        @Size(max = 150)
        String name,
        @NotNull(message = "Sale Unit Price must be required!")
        @Positive(message = "Sale Unit Price must be Positive number and lager than 0")
        BigDecimal saleUnitPrice,
        String description,
        @Positive(message = "Sale Unit Price must be Positive number and lager than 0")
        Integer categoryId
) {
}
