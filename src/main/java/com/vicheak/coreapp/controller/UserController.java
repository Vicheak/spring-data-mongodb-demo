package com.vicheak.coreapp.controller;

import com.vicheak.coreapp.dto.UserDto;
import com.vicheak.coreapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> loadAllUsers() {
        return userService.loadAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDto loadUserById(@PathVariable String id) {
        return userService.loadUserById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sort")
    public List<UserDto> loadUserSort(@RequestParam(required = false) Map<String, String> requestMap) {
        return userService.loadUserSort(requestMap);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser(@RequestBody @Valid UserDto userDto) {
        userService.saveUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateUserById(@PathVariable String id,
                               @RequestBody @Valid UserDto userDto) {
        userService.updateUserById(id, userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
    }

}
