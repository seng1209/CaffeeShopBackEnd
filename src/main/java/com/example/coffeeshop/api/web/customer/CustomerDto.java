package com.example.coffeeshop.api.web.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record CustomerDto(
        @JsonIgnore
        Integer id,
        String name,
        String phone,
        String address,
        String type) {

        public Integer getId(){
                return this.id();
        }
}
