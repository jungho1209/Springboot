package com.example.springboot.Post.dto;

import com.example.springboot.Post.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDto {
    private String accountId;
    private String email;
    private String name;
    private String password;
    private Long studentId;
    private Sex sex;
}
