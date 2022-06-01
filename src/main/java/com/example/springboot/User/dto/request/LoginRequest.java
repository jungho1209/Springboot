package com.example.springboot.User.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 작성한 내용이 리퀘스트에 저장
public class LoginRequest {

    private String accountId;
    private String password;
}
