package com.example.springboot.Post.dto.request;

import com.example.springboot.Post.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "id 에는 공백이 없어야합니다.")
    private String accountId;
    @NotBlank(message = "password 에는 공백이 없어야합니다.")
    private String password;
    private String name;
    private String email;
    private Long studentId;
    private Sex sex;
}
