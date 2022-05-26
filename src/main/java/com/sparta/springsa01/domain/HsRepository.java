package com.sparta.springsa01.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HsRepository extends JpaRepository<HsContents, Long> {
    List<HsContents> findAllByOrderByIdDesc();

    List<HsContents> findByHeroType(String heroType);

    List<HsContents> findByNickname(String nickname);

}
