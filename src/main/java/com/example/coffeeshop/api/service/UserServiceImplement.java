package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.entities.User;
import com.example.coffeeshop.api.mapper.UserMapper;
import com.example.coffeeshop.api.repository.UserRepository;
import com.example.coffeeshop.api.web.user.CreateUserDto;
import com.example.coffeeshop.api.web.user.UpdateUserDto;
import com.example.coffeeshop.api.web.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createNewUser(CreateUserDto createUserDto) {
        User user = userMapper.formUserDto(createUserDto);
        userRepository.save(user);
    }

    @Override
    public void updateUserByUsername(String username, UpdateUserDto updateUserDto) {
        if (userRepository.existsByUsername(username)){
            User user = userRepository.findByUsername(username).orElseThrow();
            userMapper.formUpdateUserDto(user, updateUserDto);

            if (updateUserDto.staffId() != null){
                Staff newStaff = new Staff();
                newStaff.setId(updateUserDto.staffId());
                user.setStaff(newStaff);
            }

            userRepository.save(user);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Username : %s is not found!...", username));
    }

    @Override
    public void deleteUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Username : %s is not found!...", username))
        );
        userRepository.delete(user);
    }

    @Override
    public UserDto findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Username : %s is not found!...", username))
        );
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto findUserByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User at Username %s and Password %s not found..!", username, password))
        );
        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserDtoList(users);
    }
}
