package com.example.memoir.domain.user.controller;

import com.example.memoir.domain.user.controller.dto.request.UserLoginRequest;
import com.example.memoir.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.memoir.domain.user.controller.dto.response.TokenResponse;
import com.example.memoir.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request) {
        return userService.login(request);
    }
}