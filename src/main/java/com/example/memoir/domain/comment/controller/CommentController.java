package com.example.memoir.domain.comment.controller;

import com.example.memoir.domain.comment.controller.dto.WriteCommentRequest;
import com.example.memoir.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feedId}")
    public void writeComment(@PathVariable("feedId") Long id,
                             @RequestBody @Valid WriteCommentRequest request) {

    }
}
