package com.example.springboot.User.service;

import com.example.springboot.User.domain.UserEntity;
import com.example.springboot.User.domain.repository.UserRepository;
import com.example.springboot.User.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository; // PostRepository 전달하는 파라미터 postRepository ??
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserRequest postRequest) {
        if (userRepository.findByAccountId(postRequest.getAccountId()).isPresent()) {
            throw new RuntimeException();
        }

        UserEntity postEntity = UserEntity.builder()
                .accountId(postRequest.getAccountId())
                .password(passwordEncoder.encode(postRequest.getPassword()))
                .email(postRequest.getEmail())
                .name(postRequest.getName())
                .studentId(postRequest.getStudentId())
                .sex(postRequest.getSex())
                .build();
        userRepository.save(postEntity);
    }
}
