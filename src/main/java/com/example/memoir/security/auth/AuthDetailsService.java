package com.example.memoir.security.auth;

import com.example.memoir.entity.user.repository.UserRepository;
import com.example.memoir.exception.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return new AuthDetails(
                userRepository.findByUserId(userId)
                        .orElseThrow(()-> UsernameNotFoundException.EXCEPTION)
        );
    }
}
