package com.example.springboot.User.dto.response;

import com.example.springboot.User.domain.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPutResponse {


    private String accountId;
    private String password;
    private String name;


    public UserPutResponse(UserEntity userEntity){
        this.accountId = userEntity.getAccountId();
        this.password = userEntity.getPassword();
        this.name = userEntity.getName();
    }
}
