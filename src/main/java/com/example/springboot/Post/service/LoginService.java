package com.example.springboot.Post.service;

import com.example.springboot.Post.LoginRequest;
import com.example.springboot.Post.domain.PostEntity;
import com.example.springboot.Post.domain.repository.PostRepository;
import com.example.springboot.Post.dto.LoginDto;
import com.example.springboot.Post.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final PostRepository postRepository;

    @Transactional
    public void postEntity(LoginRequest loginRequest) throws IllegalArgumentException {
        PostEntity postEntity = PostEntity.builder()
                .accountId(loginRequest.getAccountId())
                .password(loginRequest.getPassword())
                .build();
        postRepository.save(postEntity);
    }

    @Transactional
    public PostResponse queryResponseID(String accountId) {
        postRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
        return null;
    }

    @Transactional
    public PostResponse queryResponsePW(String password) {
        postRepository.findById(password).orElseThrow(() -> new IllegalArgumentException("해당 비밀번호가 존재하지 않습니다."));
        return null;
    }
}
