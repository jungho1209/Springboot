package com.example.springboot.user.controller;

import com.example.springboot.user.dto.request.PutRequest;
import com.example.springboot.user.dto.request.UserRequest;
import com.example.springboot.user.dto.response.UserListResponse;
import com.example.springboot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService; // UserService 클래스를 전달해주는 매개변수 userService

    @PostMapping("/signup")
    //  DTO 에 어노테이션으로 명시한 후 RequestBody 에 @Valid 어노테이션을 달면 유효성 검증을 수행한 후 검증이 통과되었을 때에만 메서드 내부로 진입
    public void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }

    @DeleteMapping("delete/{account-id}")
    public void delete(@PathVariable("account-id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/search")
    public UserListResponse searchAllDesc() {
        return userService.searchAllDesc();
    }

    @PutMapping("/edit/{account-id}")
    public String update(@PathVariable("account-id") Long id, @RequestBody PutRequest putRequest) {
        return userService.update(id, putRequest);
    }
}