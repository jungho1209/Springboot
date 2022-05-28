package com.example.springboot.User.dto.request;

import com.example.springboot.User.domain.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PutRequest {

    private String accountId;
    private String password;
    private String name;

    public PutRequest(UserEntity userEntity){
        this.accountId = userEntity.getAccountId();
        this.password = userEntity.getPassword();
        this.name = userEntity.getName();
    }
}
