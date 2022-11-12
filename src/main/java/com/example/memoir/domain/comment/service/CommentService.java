package com.example.memoir.domain.comment.service;

import com.example.memoir.domain.comment.controller.dto.WriteCommentRequest;
import com.example.memoir.domain.comment.domain.Comment;
import com.example.memoir.domain.comment.domain.repository.CommentRepository;
import com.example.memoir.domain.memoir.facade.MemoirFacade;
import com.example.memoir.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final MemoirFacade memoirFacade;

    public void writeComment(WriteCommentRequest request, Long id) {
        commentRepository.save(
                Comment.builder()
                        .comment(request.getComment())
                        .user(userFacade.getCurrentUser())
                        .memoir(memoirFacade.getMemoirId(id))
                        .build()
        );
    }
}
