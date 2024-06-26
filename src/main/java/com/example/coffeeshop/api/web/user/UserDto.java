package com.example.coffeeshop.api.web.user;


import com.example.coffeeshop.api.entities.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserDto(
        @JsonIgnore
        Integer id,
        String username,
        String password,
        @JsonIgnore
        Integer staffId,
        String staffName,
        String staffPosition) {

        public Integer getId(){
                return this.id();
        }

        public Integer getStaffId(){
                return this.staffId();
        }
}
