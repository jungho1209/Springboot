package com.example.springboot.Post.service;

import com.example.springboot.Post.domain.PostEntity;
import com.example.springboot.Post.domain.repository.PostRepository;
import com.example.springboot.Post.dto.request.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository; // PostRepository 전달하는 파라미터 postRepository ??

    @Transactional
    public void postEntity(PostRequest postRequest) throws IllegalArgumentException {
        PostEntity postEntity = PostEntity.builder()
                .accountId(postRequest.getAccountId())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .name(postRequest.getName())
                .studentId(postRequest.getStudentId())
                .sex(postRequest.getSex())
                .build();
        postRepository.save(postEntity);
    }
}
