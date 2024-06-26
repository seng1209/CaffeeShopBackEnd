package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.user.CreateUserDto;
import com.example.coffeeshop.api.web.user.UpdateUserDto;
import com.example.coffeeshop.api.web.user.UserDto;

import java.util.List;

public interface UserService {

    // create user
    void createNewUser(CreateUserDto createUserDto);

    // update user by username
    void updateUserByUsername(String username, UpdateUserDto updateUserDto);

    // delete user by username
    void deleteUserByUsername(String username);

    // select a user by username
    UserDto findUserByUsername(String username);

    // select all users
    List<UserDto> findAll();

}
