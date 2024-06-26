package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.User;
import com.example.coffeeshop.api.web.user.CreateUserDto;
import com.example.coffeeshop.api.web.user.UpdateUserDto;
import com.example.coffeeshop.api.web.user.UserDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // create user
    @Mapping(source = "staffId", target = "staff.id")
    User formUserDto(CreateUserDto createUserDto);

    // update user
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateUserDto(@MappingTarget User user, UpdateUserDto updateUserDto);

    // select a user
    @Mapping(source = "staff.id", target = "staffId")
    @Mapping(source = "staff.name", target = "staffName")
    @Mapping(source = "staff.position", target = "staffPosition")
    UserDto toUserDto(User user);

    // select all users
    List<UserDto> toUserDtoList(List<User> users);

}
