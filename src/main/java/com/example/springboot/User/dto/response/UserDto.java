package com.example.springboot.User.dto.response;

import com.example.springboot.User.domain.UserEntity;
import com.example.springboot.User.domain.type.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    private String accountId;
    private String email;
    private String name;
    private String password;
    private Long studentId;
    private Sex sex;



    public UserDto(UserEntity userEntity) {
        this.accountId = userEntity.getAccountId();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
        this.studentId = userEntity.getStudentId();
        this.sex = userEntity.getSex();
    }
}
// DB 와 연결하는 객체 ? DTO 는 DB 에서 꺼낸 값을 의미로 조작할 필요 없기 때문에 Setter 필요 없고 생성자에서 값 할당