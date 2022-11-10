package com.example.memoir.domain.user.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserUpdateRequest {

    @NotBlank(message = "이름을 입력해주세요")
    private String nickName;

    @NotBlank(message = "자기소개를 입력해주세요.")
    private String introduce;
}
