package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.UserService;
import com.example.coffeeshop.api.web.user.CreateUserDto;
import com.example.coffeeshop.api.web.user.UpdateUserDto;
import com.example.coffeeshop.api.web.user.UserDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewUser(@RequestBody CreateUserDto createUserDto){
        userService.createNewUser(createUserDto);
    }

    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public UserDto findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @GetMapping("/findUser")
    public UserDto findUserByUsernameAndPassword(@RequestParam String username, @RequestParam String password){
        return userService.findUserByUsernameAndPassword(username, password);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{username}")
    public void updateUserByUsername(@PathVariable String username, @RequestBody @Valid UpdateUserDto updateUserDto){
        userService.updateUserByUsername(username, updateUserDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{username}")
    public void deleteUserByUsername(@PathVariable String username){
        userService.deleteUserByUsername(username);
    }

}
