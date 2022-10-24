package com.example.memoir.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    ALREADY_USER_EXIST(409, "이미 존재하는 유저 입니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다.");

    private final int status;
    private final String message;
}
