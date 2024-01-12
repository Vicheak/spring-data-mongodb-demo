package com.vicheak.coreapp.service.impl;

import com.vicheak.coreapp.dto.UserDto;
import com.vicheak.coreapp.entity.User;
import com.vicheak.coreapp.mapper.UserMapper;
import com.vicheak.coreapp.repository.UserRepository;
import com.vicheak.coreapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void saveUser(UserDto userDto) {
        User newUser = userMapper.toUser(userDto);
        userRepository.insert(newUser);
    }

}
