package com.soft1851.spring.boot.configration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author wl
 * @ClassNamesadds
 * @Description HTTPS测试
 * @Date 2020/5/12
 * @Version 1.0
 */
@RestController
@Slf4j
 public class SecuredServerController {

    @RequestMapping("/secured")
    public String secured() {
        log.info("Inside secured()");
        return "Hello user !!! : " + LocalDateTime.now();
    }
}
