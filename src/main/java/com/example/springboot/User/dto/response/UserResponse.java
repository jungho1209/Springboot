package com.example.springboot.User.dto.response;

import com.example.springboot.User.domain.type.Sex;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserResponse {
    private final String accountId;
    private final String name;
    private final String email;
    private final Long studentId;
    private final String password;
    private final Sex sex;
}
