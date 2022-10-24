package com.example.memoir.exception;

import com.example.memoir.exception.error.ErrorCode;
import com.example.memoir.exception.handler.MemoirException;

public class AlreadyUserExistException extends MemoirException {

    public static final MemoirException EXCEPTION = new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(ErrorCode.ALREADY_USER_EXIST);
    }
}
