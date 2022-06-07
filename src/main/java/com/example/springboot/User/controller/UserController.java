package com.example.springboot.user.controller;

import com.example.springboot.user.dto.request.PutRequest;
import com.example.springboot.user.dto.request.UserRequest;
import com.example.springboot.user.dto.response.UserListResponse;
import com.example.springboot.user.dto.response.UserSearchResponse;
import com.example.springboot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest userRequest) {
        userService.signUp(userRequest);
    }

    @DeleteMapping("{account-id}")
    public void delete(@PathVariable("account-id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/search")
    public UserListResponse searchAllDesc() {
        return userService.searchAllDesc();
    }

    @PutMapping("/{account-id}")
    public String update(@PathVariable("account-id") Long id,
                         @RequestBody PutRequest putRequest) {
        return userService.update(id, putRequest);
    }

    @GetMapping("/{accountId}")
    public UserSearchResponse searchUser(@PathVariable("accountId") String accountId) {
        return userService.searchUser(accountId);
    }

}