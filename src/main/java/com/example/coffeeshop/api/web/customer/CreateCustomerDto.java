package com.example.coffeeshop.api.web.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCustomerDto(
        @NotBlank(message = "Name must be required!")
        @Size(max = 50)
        String name,
        @NotBlank(message = "Phone must be required!")
        @Size(max = 20)
        String phone,
        @NotBlank(message = "Address must be required!")
        @Size(max = 255)
        String address,
        @NotBlank(message = "Type must be required!")
        @Size(max = 30)
        String type
) {
}
