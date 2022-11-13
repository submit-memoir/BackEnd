package com.example.memoir.domain.comment.service;

import com.example.memoir.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.memoir.domain.comment.controller.dto.request.WriteCommentRequest;
import com.example.memoir.domain.comment.domain.Comment;
import com.example.memoir.domain.comment.domain.repository.CommentRepository;
import com.example.memoir.domain.comment.exception.CommentNotUpdateException;
import com.example.memoir.domain.comment.facade.CommentFacade;
import com.example.memoir.domain.memoir.facade.MemoirFacade;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final MemoirFacade memoirFacade;

    private final CommentFacade commentFacade;

    public void commentWrite(WriteCommentRequest request, Long id) {
        commentRepository.save(
                Comment.builder()
                        .comment(request.getComment())
                        .user(userFacade.getCurrentUser())
                        .memoir(memoirFacade.getMemoirId(id))
                        .build()
        );
    }

    public void commentUpdate(UpdateCommentRequest request, Long commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentId(commentId);

        if(!user.equals(comment.getUser())) {
            throw CommentNotUpdateException.EXCEPTION;
        }

        comment.commentUpdate(request.getComment());
    }
}
