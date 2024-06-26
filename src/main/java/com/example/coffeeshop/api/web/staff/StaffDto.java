package com.example.coffeeshop.api.web.staff;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record StaffDto(
        @JsonIgnore
        Integer id,
        String image,
        String name,
        String gender,
        LocalDate birthDate,
        String phone,
        String address,
        String position,
        BigDecimal salary,
        LocalDate hiredDate,
        Boolean stopWork) {

        public Integer getId(){
                return this.id();
        }
}
