package com.example.springboot.user.dto.response;

import com.example.springboot.user.domain.type.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResponse {

    private final List<UserResponse> userList;

    @Getter
    @Builder
    public static class UserResponse {
        private final String accountId;
        private final String email;
        private final String name;
        private final Long studentId;
        private final Sex sex;
    }
}
