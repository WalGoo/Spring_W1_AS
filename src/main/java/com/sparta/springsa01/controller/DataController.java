package com.sparta.springsa01.controller;

import com.sparta.springsa01.domain.*;
import com.sparta.springsa01.service.HsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class DataController {
    private final HsRepository hsRepository;
    private final HsService hsService;

    // 글 만들기
    @PostMapping("api/hsDecks")
    public HsContents insertDeckCont(@RequestBody HsRequestDto hsRequestDto) {
        HsContents hsContents = new HsContents(hsRequestDto);
        return hsRepository.save(hsContents);
    }


    // 페이지 접속 시 전체 글 조회
    @GetMapping("api/hsDecks")
    public List<HsContents> loadDeck() {
        System.out.println(hsRepository.findAllByOrderByIdDesc());
        return hsRepository.findAllByOrderByIdDesc();
    }

    // 닉네임으로 글 조회
    @PostMapping("api/nicknames/{nickname}")
    public List<HsContents> loadDeckByNickname(@PathVariable String nickname) {
        return hsRepository.findByNickname(nickname);
    }

    // 직업 분류로 글 조회
    @PostMapping("api/heroTypes/{heroType}")
    public List<HsContents> loadDeckByHeroType(@PathVariable String heroType) {
        return hsRepository.findByHeroType(heroType);
    }

    // 삭제
    @DeleteMapping("api/hsDecks/{id}")
    public Long deleteHsDeckCont(@PathVariable Long id, @RequestBody HsRequestDto hsRequestDto) {
        hsService.delete(id, hsRequestDto);
        return id;
    }

    // 수정
    @PutMapping("api/hsDecks/{id}")
    public Long updateDeckCont(@PathVariable Long id, @RequestBody HsRequestDto hsRequestDto) {
        hsService.update(id, hsRequestDto);
        return id;

    }
}
