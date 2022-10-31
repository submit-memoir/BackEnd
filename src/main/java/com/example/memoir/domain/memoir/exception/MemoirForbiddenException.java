package com.example.memoir.domain.memoir.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class MemoirForbiddenException extends MemoirException {

    public static final MemoirException EXCEPTION = new MemoirForbiddenException();

    private MemoirForbiddenException() {
        super(ErrorCode.MEMOIR_FORBIDDEN);
    }
}
