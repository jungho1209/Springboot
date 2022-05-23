package com.example.springboot.User.controller;

import com.example.springboot.User.dto.UserDto;
import com.example.springboot.User.dto.request.UserRequest;
import com.example.springboot.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService; // UserService 클래스를 전달해주는 매개변수 userService

    @GetMapping("/signup")
    public List<UserDto> searchAllDesc() {
        return userService.searchAllDesc();
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }

}
