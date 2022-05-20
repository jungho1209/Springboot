package com.example.springboot.Post.dto.response;

import com.example.springboot.Post.domain.type.Sex;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostResponse {
    private final String accountId;
    private final String name;
    private final String email;
    private final Long studentId;
    private final String password;
    private final Sex sex;
}
