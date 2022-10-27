package com.example.memoir.security.jwt;

import com.example.memoir.security.auth.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final AuthDetailsService authDetailsService;

    @Value("${")
}
