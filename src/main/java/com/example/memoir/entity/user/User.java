package com.example.memoir.entity.user;

import com.example.memoir.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseIdEntity {

    @Column(length = 10, unique = true)
    private String nickName;

    @Column(length = 30, unique = true)
    private String userId;

    private String password;

    @Builder
    public User(String nickName, String userId, String password) {
        this.nickName = nickName;
        this.userId = userId;
        this.password = password;
    }
}
