package com.example.coffeeshop.api.web.item;

import jakarta.validation.constraints.Positive;

public record UpdateItemDto(
        String name,
        String image,
        @Positive(message = "CategoryID must be Integer and lager than 0!...")
        Integer categoryId
) {
}
