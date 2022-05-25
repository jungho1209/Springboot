package com.example.springboot.User.controller;

import com.example.springboot.User.dto.request.UserRequest;
import com.example.springboot.User.dto.response.UserListDto;
import com.example.springboot.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService; // UserService 클래스를 전달해주는 매개변수 userService

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }

    @DeleteMapping("delete/{account-id}")
    public void delete(@PathVariable("account-id") Long id){
        userService.delete(id);
    }

    @GetMapping("/user/search") // 리스트 타입 바꿈
    public UserListDto searchAllDesc(){
        return userService.searchAllDesc();
    }
}