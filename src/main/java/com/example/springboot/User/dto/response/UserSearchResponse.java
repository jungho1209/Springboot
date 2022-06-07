package com.example.springboot.user.dto.response;

import com.example.springboot.user.domain.type.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSearchResponse {

    private final String accountId;
    private final String name;
    private final Sex sex;

}
