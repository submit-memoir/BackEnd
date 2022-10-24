package com.example.memoir.service;

import com.example.memoir.dto.UserSignUpRequest;
import com.example.memoir.entity.user.User;
import com.example.memoir.entity.user.repository.UserRepository;
import com.example.memoir.exception.AlreadyUserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void signup(UserSignUpRequest request) {

        if(userRepository.findByUserId(request.getUserId()).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }

        User user = User.builder()
                .nickName(request.getNickName())
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }
}
