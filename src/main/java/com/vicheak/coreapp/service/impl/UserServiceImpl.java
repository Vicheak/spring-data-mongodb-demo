package com.vicheak.coreapp.service.impl;

import com.vicheak.coreapp.dto.UserDto;
import com.vicheak.coreapp.entity.User;
import com.vicheak.coreapp.mapper.UserMapper;
import com.vicheak.coreapp.repository.UserRepository;
import com.vicheak.coreapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> loadAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public UserDto loadUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User has not been found!")
                );
        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> loadUserSort(Map<String, String> requestMap) {
        String field = "id";
        if (requestMap.containsKey("_field"))
            field = requestMap.get("_field");

        String direction = "";
        if (requestMap.containsKey("_direction"))
            direction = requestMap.get("_direction");

        Sort sort = Sort.by(direction.equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC, field);

        return userRepository.findAll(sort).stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public Page<UserDto> loadUserPagination(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User newUser = userMapper.toUser(userDto);
        userRepository.insert(newUser);
    }

    @Override
    public void updateUserById(String id, UserDto userDto) {
        User updatedUser = userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User has not been found!")
                );

        updatedUser.setUsername(userDto.username());
        updatedUser.setGender(userDto.gender());
        updatedUser.setBirthDate(LocalDate.parse(userDto.birthDate()));

        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User has not been found!")
                );

        userRepository.delete(user);
    }

}

