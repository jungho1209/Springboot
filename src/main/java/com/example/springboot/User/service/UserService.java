package com.example.springboot.user.service;

import com.example.springboot.user.domain.UserEntity;
import com.example.springboot.user.domain.repository.UserRepository;
import com.example.springboot.user.dto.request.PutRequest;
import com.example.springboot.user.dto.request.UserRequest;
import com.example.springboot.user.dto.response.UserListResponse;
import com.example.springboot.user.dto.response.UserListResponse.UserResponse;
import com.example.springboot.user.dto.response.UserSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
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
                        .build())
                .collect(Collectors.toList());

        return new UserListResponse(userList);
    }

    @Transactional(readOnly = true)
    public UserSearchResponse searchUser(String accountId) {
        UserEntity userEntity = userRepository.findByAccountId(accountId)
                .orElseThrow(RuntimeException::new);

        return UserSearchResponse.builder()
                .accountId(userEntity.getAccountId())
                .name(userEntity.getName())
                .sex(userEntity.getSex())
                .build();
    }

    @Transactional
    public String update(Long id, PutRequest putRequest) {
        UserEntity userEntity = userRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("해당 계정이 없습니다. id = + id"));

        userEntity.update(putRequest.getAccountId(),
                passwordEncoder.encode(putRequest.getPassword()),
                putRequest.getName(),
                putRequest.getEmail(),
                putRequest.getStudentId(),
                putRequest.getSex());
        return "수정 완료";
    }

}