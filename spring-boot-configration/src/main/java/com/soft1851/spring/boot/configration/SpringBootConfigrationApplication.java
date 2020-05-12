package com.soft1851.spring.boot.configration;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootConfigrationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootConfigrationApplication.class)
                .bannerMode(Banner.Mode.CONSOLE).run(args);
    }

}
