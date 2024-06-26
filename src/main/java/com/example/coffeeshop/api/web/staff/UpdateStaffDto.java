package com.example.coffeeshop.api.web.staff;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateStaffDto(
        String image,
        @Size(max = 50)
        String name,
        @Size(max = 6)
        String gender,
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
        LocalDate birthDate,
        @Size(max = 20)
        String phone,
        @Size(max = 255)
        String address,
        @Size(max = 150)
        String position,
        @Positive(message = "Salary is positive number and lager than 0 ")
        BigDecimal salary
) {
}
