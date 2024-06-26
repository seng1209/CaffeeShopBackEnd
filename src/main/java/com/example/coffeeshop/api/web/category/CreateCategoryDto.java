package com.example.coffeeshop.api.web.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryDto(
        @NotBlank(message = "Name must be required!")
        @Size(max = 255)
        String name,
        String description
) {
}
