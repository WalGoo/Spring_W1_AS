package com.sparta.springsa01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity //(name="HsContents")
public class HsContents extends Timestamped {
    // PK
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;

    // 닉네임
    @Column(nullable = false, length = 10)
    private String nickname;

    // 평가
    @Column(nullable = false)
    private String contents;


    // 직업 분류
    @Column(nullable = false)
    private String heroType;

    @Column(nullable = false)
    private String password;


    public String getContents() {
        return contents;
    }
    public String getPassword() { return password; }

    public HsContents(HsRequestDto hsRequestDto) {
        this.contents = hsRequestDto.getContents();
        this.heroType = hsRequestDto.getHeroType();
        this.nickname = hsRequestDto.getNickname();
        this.password = hsRequestDto.getPassword();
    }

    public void update(HsRequestDto hsRequestDto) {
        this.contents = hsRequestDto.getContents();
        this.password = hsRequestDto.getPassword();
    }


}

