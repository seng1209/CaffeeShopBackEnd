package com.example.coffeeshop.api.web.user;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateUserDto(
        @Size(max = 20)
        String username,
        @Size(max = 16)
        String password,
        @Positive(message = "StaffID must be Integer number lager than 0!")
        Long staffId
) {
}
