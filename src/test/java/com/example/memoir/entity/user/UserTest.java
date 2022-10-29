package com.example.memoir.entity.user;

import com.example.memoir.GetUser;
import com.example.memoir.entity.user.repository.UserRepository;
import com.example.memoir.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    private static final User user = GetUser.user;

    @Test
    void 유저_객체_생성() {
        User user = new User();
        assertNull(user.getUserId());
        assertNull(user.getNickName());
        assertNull(user.getPassword());

        Assertions.assertThat(userRepository.count()).isEqualTo(1L);
    }
}