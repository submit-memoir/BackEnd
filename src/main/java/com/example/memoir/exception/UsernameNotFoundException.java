package com.example.memoir.exception;

import com.example.memoir.exception.error.ErrorCode;
import com.example.memoir.exception.handler.MemoirException;

public class UsernameNotFoundException extends MemoirException {

    public static final MemoirException EXCEPTION = new UsernameNotFoundException();

    private UsernameNotFoundException() {
        super(ErrorCode.USERNAME_NOT_FOUND);
    }
}
