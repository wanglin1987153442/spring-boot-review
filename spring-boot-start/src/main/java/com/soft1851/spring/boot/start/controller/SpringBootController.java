package com.soft1851.spring.boot.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @ClassNameSpringBootController
 * @Description 标准的Spring Boot RESTController
 * @Date 2020/5/11
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class SpringBootController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}