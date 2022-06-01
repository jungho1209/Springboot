package com.example.springboot.User.dto.request;

import com.example.springboot.User.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PutRequest {

    private String accountId;
    private String password;
    private String name;
    private String email;
    private Long studentId;
    private Sex sex;


}