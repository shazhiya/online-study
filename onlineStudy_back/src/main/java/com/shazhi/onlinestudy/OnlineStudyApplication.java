package com.shazhi.onlinestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackages = "com.shazhi.onlinestudy.entity")
public class OnlineStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineStudyApplication.class, args);
    }
}

