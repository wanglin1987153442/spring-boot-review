package com.soft1851.spring.boot.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringBootScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduleApplication.class, args);
    }

}
