package com.example.springboot.User.controller;

import com.example.springboot.User.dto.request.UserRequest;
import com.example.springboot.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService postService; // PostService 클래스를 전달해주는 매개변수 postService

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest postRequest) {
        postService.signUp(postRequest);
    }
}
