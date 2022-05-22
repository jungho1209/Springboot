package com.example.springboot.Post.controller;

import com.example.springboot.Post.LoginRequest;
import com.example.springboot.Post.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/in")
    public void postEntity(@RequestBody @Valid LoginRequest loginRequest) throws IllegalArgumentException {
        loginService.postEntity(loginRequest);
    }
}
