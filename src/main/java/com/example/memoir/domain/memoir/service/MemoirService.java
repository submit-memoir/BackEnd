package com.example.memoir.domain.memoir.service;

import com.example.memoir.domain.memoir.controller.dto.request.MemoirUpdateRequest;
import com.example.memoir.domain.memoir.controller.dto.request.MemoirWriteRequest;
import com.example.memoir.domain.memoir.controller.dto.response.MemoirDetailsResponse;
import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.memoir.domain.repository.MemoirRepository;
import com.example.memoir.domain.memoir.exception.MemoirNotDeleteException;
import com.example.memoir.domain.memoir.exception.MemoirNotUpdateException;
import com.example.memoir.domain.memoir.facade.MemoirFacade;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoirService {

    private final MemoirRepository memoirRepository;
    private final UserFacade userFacade;
    private final MemoirFacade memoirFacade;

    public void memoirWrite(MemoirWriteRequest request) {
        User user = userFacade.getCurrentUser();

        memoirRepository.save(Memoir.builder()
                .title(request.getTitle())
                .goal(request.getGoal())
                .felt(request.getFelt())
                .learned(request.getLearned())
                .nextGoal(request.getNextGoal())
                .user(user)
                .build());
    }

    @Transactional
    public void memoirDelete(Long memoirId) {
        Memoir memoir = memoirFacade.getMemoirId(memoirId);
        User user = userFacade.getCurrentUser();

        if(!user.equals(memoir.getUser())) {
            throw MemoirNotDeleteException.EXCEPTION;
        }

        memoirRepository.delete(memoir);
    }

    @Transactional
    public void memoirUpdate(Long memoirId, MemoirUpdateRequest request) {
        User user = userFacade.getCurrentUser();
        Memoir memoir = memoirFacade.getMemoirId(memoirId);

        if(!user.equals(memoir.getUser())) {
            throw MemoirNotUpdateException.EXCEPTION;
        }

        memoir.updateMemoir(
                request.getTitle(),
                request.getGoal(),
                request.getLearned(),
                request.getFelt(),
                request.getNextGoal()
        );
    }

    @Transactional
    public MemoirDetailsResponse memoirDetails(Long memoirId) {
        Memoir memoir = memoirFacade.getMemoirId(memoirId);

        return MemoirDetailsResponse.builder()
                .title(memoir.getTitle())
                .felt(memoir.getFelt())
                .goal(memoir.getGoal())
                .learned(memoir.getLearned())
                .nextGoal(memoir.getNextGoal())
                .nickName(memoir.getUser().getNickName())
                .modifiedAt(memoir.getModifiedAt())
                .build();
    }
}
