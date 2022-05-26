package com.sparta.springsa01.service;

import com.sparta.springsa01.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class HsService {
    private final HsRepository hsRepository;


    @Transactional
    public Long update(Long id, HsRequestDto hsRequestDto) {
        HsContents hsContents = hsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(hsContents.getPassword().equals(hsRequestDto.getPassword())) {
            hsContents.update(hsRequestDto);
            return hsContents.getId();
        }
        return hsContents.getId();
    }

    @Transactional
    public Long delete(Long id, HsRequestDto hsRequestDto) {
        HsContents hsContents = hsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(hsContents.getPassword().equals(hsRequestDto.getPassword())) {
            hsRepository.deleteById(id);
            return hsContents.getId();
        }
        return hsContents.getId();
    }
}
