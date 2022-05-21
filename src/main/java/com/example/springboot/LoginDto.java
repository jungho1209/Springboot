package com.example.springboot;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    private String accountId;
    private String password;
}
