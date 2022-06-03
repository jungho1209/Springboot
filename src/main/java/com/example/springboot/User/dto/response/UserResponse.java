package com.example.springboot.user.dto.response;

import com.example.springboot.user.domain.type.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse { // DB 에 있는 값 가져오는 역할

    private final String accountId;
    private final String password;
    private final String email;
    private final String name;
    private final Long studentId;
    private final Sex sex;
}
// DB 와 연결하는 객체 ? DTO 는 DB 에서 꺼낸 값을 의미로 조작할 필요 없기 때문에 Setter 필요 없고 생성자에서 값 할당