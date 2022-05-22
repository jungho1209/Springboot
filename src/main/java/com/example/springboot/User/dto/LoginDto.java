package com.example.springboot.User.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto { // 된 듯
    private String accountId;
    private String password;
}
// 이런 거 지정안해줬다고 뜨는데 초기화 다 해줘야 하는지 여쭤보기 @Builder 로 다가