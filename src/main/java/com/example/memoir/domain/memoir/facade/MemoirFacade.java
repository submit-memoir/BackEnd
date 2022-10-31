package com.example.memoir.domain.memoir.facade;

import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.memoir.domain.repository.MemoirRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemoirFacade {

    private final MemoirRepository memoirRepository;

}
