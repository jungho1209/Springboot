package com.example.springboot.user.dto.request;

import com.example.springboot.user.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "id 에는 공백이 없어야합니다.")
    private String accountId;

    @NotBlank(message = "password 에는 공백이 없어야합니다.")
    private String password;

    private String email;
    private String name;
    private Long studentId;
    private Sex sex;
}
