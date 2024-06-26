package com.example.coffeeshop.api.web.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateUserDto(
        @NotBlank(message = "Username must be required!")
        @Size(max = 20)
        String username,
        @NotBlank(message = "Password must be required!")
        @Size(max = 16)
        String password,
        @NotNull(message = "StaffID must be required!")
        @Positive(message = "StaffID must be Integer number lager than 0!")
        Long staffId
) {
}
