package com.soft1851.spring.boot.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @ClassNameHelloController
 * @Description TODO
 * @Date 2020/5/11
 * @Version 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot";
    }

    /**
     * 带路径参数请求
     *
     * @param name
     * @return String
     */
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return "Hello, " + name;
    }

    /**
     * 带查询参数请求
     *
     * @param name
     * @return String
     */
    @GetMapping("/hello1")
    public String hello1(@RequestParam(name = "name") String name) {
        return "Hello, " + name;
    }
}