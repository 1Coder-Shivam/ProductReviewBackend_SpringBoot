package com.nagarro.mapper;

import com.nagarro.dto.UserDto;
import com.nagarro.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToUser(UserDto userDto);

    UserDto userToDto(User user);
}
