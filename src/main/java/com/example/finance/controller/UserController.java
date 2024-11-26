package com.example.finance.controller;

import com.financas.dto.CreateUserDTO;
import com.financas.dto.UserDTO;
import com.financas.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }
}
