package com.devexperts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
            SpringApplication.run(ApplicationRunner.class, args);
    }

/*
    @Bean
    AccountService accountService() {
        return new AccountServiceImpl();
    }
*/
}
