package com.vicheak.coreapp.mapper;

import com.vicheak.coreapp.dto.UserDto;
import com.vicheak.coreapp.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setGender(userDto.gender());
        user.setBirthDate(LocalDate.parse(userDto.birthDate()));
        return user;
    }

}
