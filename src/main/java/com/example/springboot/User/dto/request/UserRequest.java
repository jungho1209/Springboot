package com.example.springboot.User.dto.request;

import com.example.springboot.User.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor // @NotBlank 를 넣어야할까..?
public class UserRequest {
    @NotBlank(message = "id 에는 공백이 없어야합니다.")
    private String accountId;
    @NotBlank(message = "password 에는 공백이 없어야합니다.")
    private String password;
    private String name; // @NotBlank 를 안 넣으니 오류가 해결이 됐다
    private String email;
    private Long studentId;
    private Sex sex;
}
