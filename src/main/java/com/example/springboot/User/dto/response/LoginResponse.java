package com.example.springboot.user.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponse {
    private String accountId;
    private String password;
}