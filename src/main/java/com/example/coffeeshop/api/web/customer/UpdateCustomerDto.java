package com.example.coffeeshop.api.web.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCustomerDto(
        @Size(max = 50)
        String name,
        @Size(max = 20)
        String phone,
        @Size(max = 255)
        String address,
        @Size(max = 30)
        String type
) {
}
