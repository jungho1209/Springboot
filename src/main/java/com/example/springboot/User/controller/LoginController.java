package com.example.springboot.user.controller;

import com.example.springboot.user.dto.request.LoginRequest;
import com.example.springboot.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/signin")
    public void logIn(@RequestBody LoginRequest loginRequest) {
        loginService.logIn(loginRequest);
    }
}
