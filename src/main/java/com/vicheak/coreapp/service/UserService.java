package com.vicheak.coreapp.service;

import com.vicheak.coreapp.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<UserDto> loadAllUsers();

    UserDto loadUserById(String id);

    List<UserDto> loadUserSort(Map<String, String> requestMap);

    Page<UserDto> loadUserPagination(Map<String, String> requestMap);

    void saveUser(UserDto userDto);

    void updateUserById(String id, UserDto userDto);

    void deleteUserById(String id);

}
