package com.example.memoir.domain.memoir.controller;

import com.example.memoir.domain.memoir.controller.dto.request.MemoirWriteRequest;
import com.example.memoir.domain.memoir.service.MemoirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/memoir")
@RestController
public class MemoirController {

    private final MemoirService memoirService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/write")
    public void memoirWrite(@RequestBody @Valid MemoirWriteRequest request) {
        memoirService.memoirWrite(request);
    }
}
