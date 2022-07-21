package com.example.zadanie;

import com.example.zadanie.repository.NewsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

public class ZadanieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadanieApplication.class, args);
    }


}
