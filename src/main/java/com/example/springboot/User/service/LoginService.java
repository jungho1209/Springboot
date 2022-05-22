package com.example.springboot.User.service;

import com.example.springboot.User.domain.UserEntity;
import com.example.springboot.User.domain.repository.UserRepository;
import com.example.springboot.User.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void logIn(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByAccountId(loginRequest.getAccountId())
                .orElseThrow(RuntimeException::new);

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException();
        }
    }
}
