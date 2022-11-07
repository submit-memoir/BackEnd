package com.example.memoir.domain.memoir.controller.dto.response;

import com.example.memoir.domain.memoir.domain.Memoir;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class MemoirResponse {

    private final String title;

    private final String goal;

    private final String learned;

    private final String felt;

    private final LocalDate modifiedAt;

    private final String nickName;

    public MemoirResponse(Memoir memoir) {
        title = memoir.getTitle();
        goal = memoir.getGoal();
        learned = memoir.getLearned();
        felt = memoir.getFelt();
        modifiedAt = memoir.getModifiedAt();
        nickName = memoir.getNickName();
    }
}
