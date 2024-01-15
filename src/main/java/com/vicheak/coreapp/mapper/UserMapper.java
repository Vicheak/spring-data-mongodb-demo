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

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .gender(user.getGender())
                .birthDate(user.getBirthDate().toString())
                .build();
    }

}
