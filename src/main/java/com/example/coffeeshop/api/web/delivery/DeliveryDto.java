package com.example.coffeeshop.api.web.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Lob;

import java.time.LocalDate;

public record DeliveryDto(
        @JsonIgnore
        Long id,
        String uuid,
        LocalDate deliveryDate,
        String address) {

    public Long getId(){
        return this.id();
    }

}
