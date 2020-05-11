package com.soft1851.spring.boot.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wl
 * @ClassNameSpringWebController
 * @Description  标准的Spring MVC控制器
 * @Date 2020/5/11
 * @Version 1.0
 */
@Controller
@RequestMapping("/springWeb")
@ResponseBody
public class SpringWebController {
    @RequestMapping("/hello")
    public String hello() {
        return "<h2>Hello, Spring Boot!<h2>";
    }
}