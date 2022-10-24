package com.example.memoir.exception.handler;

import com.example.memoir.exception.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemoirException extends RuntimeException{

    private final ErrorCode errorCode;
}
