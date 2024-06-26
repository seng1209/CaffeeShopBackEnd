package com.example.coffeeshop.api.web.staff;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateStaffDto(
//        @NotBlank(message = "Image must be required!")
        String image,
        @NotBlank(message = "Name must be required!")
        @Size(max = 50)
        String name,
        @NotBlank(message = "Gender must be required!")
        @Size(max = 6)
        String gender,
        @NotNull(message = "Birth Date must be required!")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
        LocalDate birthDate,
        @NotBlank(message = "Phone must be required!")
        @Size(max = 20)
        String phone,
        @NotBlank(message = "Address must be required!")
        @Size(max = 255)
        String address,
        @NotBlank(message = "Position must be required!")
        @Size(max = 150)
        String position,
        @NotNull(message = "Salary must be required!")
        @Positive(message = "Salary is positive number and lager than 0 ")
        BigDecimal salary
) {
}
