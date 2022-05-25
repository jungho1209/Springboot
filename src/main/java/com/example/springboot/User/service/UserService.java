package com.example.springboot.User.service;

import com.example.springboot.User.domain.UserEntity;
import com.example.springboot.User.domain.repository.UserRepository;
import com.example.springboot.User.dto.request.UserRequest;
import com.example.springboot.User.dto.response.UserDto;
import com.example.springboot.User.dto.response.UserListDto;
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
    public void delete(Long id){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 계정이 없습니다. id = + id"));
        userRepository.delete(userEntity);
    }

    @Transactional(readOnly = true)
    public UserListDto searchAllDesc(){

        List<UserDto> userDtoList = userRepository.findAllByOrderByIdDesc()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
        return new UserListDto(userDtoList);
    }
}