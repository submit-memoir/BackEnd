package com.example.memoir.domain.user.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserIUpdateRequest {

    @NotBlank(message = "현재비밀번호를 입력해주세요")
    private String CurrentPassword;


}
