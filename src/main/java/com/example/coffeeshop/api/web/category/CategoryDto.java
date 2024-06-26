package com.example.coffeeshop.api.web.category;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record CategoryDto(
        @JsonIgnore
        Integer id,
        String name,
        String description) {

        public Integer getId(){
                return this.id();
        }
}
