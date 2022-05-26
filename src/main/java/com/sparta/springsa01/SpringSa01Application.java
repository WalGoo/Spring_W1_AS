package com.sparta.springsa01;

import com.sparta.springsa01.domain.HsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringSa01Application {

    public static void main(String[] args) { SpringApplication.run(SpringSa01Application.class, args);
    }
}
