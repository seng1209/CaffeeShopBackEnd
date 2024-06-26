package com.example.coffeeshop.api.web.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UpdateProductDto(
        @Size(max = 150)
        String name,
        @Positive(message = "Sale Unit Price must be Positive number and lager than 0")
        BigDecimal saleUnitPrice,
        String description,
        String image,
        @Positive(message = "Sale Unit Price must be Positive number and lager than 0")
        Integer categoryId
) {
}
