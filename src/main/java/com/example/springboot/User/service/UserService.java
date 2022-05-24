package com.example.springboot.User.service;

import com.example.springboot.User.domain.UserEntity;
import com.example.springboot.User.domain.repository.UserRepository;
import com.example.springboot.User.dto.UserDto;
import com.example.springboot.User.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository; // UserRepository 전달해주는 매개변수 userRepository
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserRequest userRequest) {
        if (userRepository.findByAccountId(userRequest.getAccountId()).isPresent()) {
            throw new RuntimeException();
        }

        UserEntity userEntity = UserEntity.builder()
                .accountId(userRequest.getAccountId())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .studentId(userRequest.getStudentId())
                .sex(userRequest.getSex())
                .build();
        userRepository.save(userEntity);
    }

    @Transactional(readOnly = true)

    public List<UserDto> searchAllDesc() {
        return userRepository.findAllByOrderByIdDesc().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }
}
