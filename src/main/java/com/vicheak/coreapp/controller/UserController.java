package com.vicheak.coreapp.controller;

import com.vicheak.coreapp.dto.UserDto;
import com.vicheak.coreapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser(@RequestBody @Valid UserDto userDto){
        userService.saveUser(userDto);
    }

}
