package com.example.memoir.domain.memoir.service;

import com.example.memoir.domain.memoir.controller.dto.request.MemoirWriteRequest;
import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.memoir.domain.repository.MemoirRepository;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemoirService {

    private final MemoirRepository memoirRepository;
    private final UserFacade userFacade;

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
}
