package com.example.springboot.user.service;

import com.example.springboot.user.domain.UserEntity;
import com.example.springboot.user.domain.repository.UserRepository;
import com.example.springboot.user.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void logIn(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByAccountId(loginRequest.getAccountId())
                .orElseThrow(RuntimeException::new);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException(); // loginRequest 의 비번과 , user 의 비번이 같은지 확인
        } // RuntimeException 은 우선 500코드를 띄움, 다른 코드를 띄우기 위해서 클래스를 만들어 따로 예외를 처리해줌.
    }
}