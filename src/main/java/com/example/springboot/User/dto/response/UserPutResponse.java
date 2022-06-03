package com.example.springboot.user.dto.response;

import com.example.springboot.user.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPutResponse {

    private String accountId;
    private String password;
    private String name;
    private String email;
    private Long studentId;
    private Sex sex;

}
