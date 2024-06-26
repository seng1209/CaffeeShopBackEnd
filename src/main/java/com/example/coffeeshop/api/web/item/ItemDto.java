package com.example.coffeeshop.api.web.item;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record ItemDto(
        @JsonIgnore
        Integer id,
        String name,
        String image,
        @JsonIgnore
        Integer categoryId,
        String category) {

    public Integer getId(){
        return this.id();
    }
    public Integer getCategoryId(){
        return this.categoryId();
    }
}
