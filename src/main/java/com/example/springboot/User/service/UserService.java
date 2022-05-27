package com.example.springboot.User.service;

import com.example.springboot.User.domain.UserEntity;
import com.example.springboot.User.domain.repository.UserRepository;
import com.example.springboot.User.dto.request.PutRequest;
import com.example.springboot.User.dto.request.UserRequest;
import com.example.springboot.User.dto.response.UserListResponse;
import com.example.springboot.User.dto.response.UserListResponse.UserResponse;
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

    @Transactional
    public void delete(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 계정이 없습니다. id = + id"));
        userRepository.delete(userEntity);
    }


    @Transactional(readOnly = true)
    public UserListResponse searchAllDesc() {

        List<UserResponse> userList = userRepository.findAllByOrderByIdDesc()
                .stream()
                .map(userEntity -> UserResponse.builder()
                        .accountId(userEntity.getAccountId())
                        .email(userEntity.getEmail())
                        .name(userEntity.getName())
                        .studentId(userEntity.getStudentId())
                        .sex(userEntity.getSex())
                        .build()).collect(Collectors.toList());

        return new UserListResponse(userList);
    }

    @Transactional
    public Long update(Long id, PutRequest putRequest){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 계정이 없습니다. id = + id"));
        userEntity.update(putRequest.getAccountId(), putRequest.getPassword(), putRequest.getName());
        return id;
    }

}