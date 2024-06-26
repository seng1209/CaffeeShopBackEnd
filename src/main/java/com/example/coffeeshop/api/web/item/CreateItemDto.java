package com.example.coffeeshop.api.web.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateItemDto(
        @NotBlank(message = "Name must be required!")
        String name,
        @NotBlank(message = "Image must be required!")
        String image,
        @Positive(message = "CategoryID must be Integer and lager than 0!...")
        Integer categoryId
) {
}
