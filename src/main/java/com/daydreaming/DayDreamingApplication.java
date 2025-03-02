package com.daydreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing // UPDATE <<created_at, updated at>> automatically
@SpringBootApplication
public class DayDreamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DayDreamingApplication.class, args);
    }
}
