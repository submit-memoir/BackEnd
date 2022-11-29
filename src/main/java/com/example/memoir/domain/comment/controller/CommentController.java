package com.example.memoir.domain.comment.controller;

import com.example.memoir.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.memoir.domain.comment.controller.dto.request.WriteCommentRequest;
import com.example.memoir.domain.comment.controller.dto.response.CommentResponse;
import com.example.memoir.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{memoirId}")
    public void writeComment(@PathVariable("memoirId") Long id,
                             @RequestBody @Valid WriteCommentRequest request) {
        commentService.commentWrite(request, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{commentId}")
    public void updateComment(@PathVariable("commentId") Long commentId,
                              @RequestBody @Valid UpdateCommentRequest request) {
        commentService.commentUpdate(request, commentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.commentDelete(commentId);
    }

    @GetMapping("/{memoirId}")
    public List<CommentResponse> commentList(@PathVariable Long memoirId) {
        return commentService.commentList(memoirId);
    }
}
