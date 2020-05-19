package com.soft1851.gongcheng.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wl
 * @ClassNameasd
 * @Description TODO
 * @Date 2020/5/17
 * @Version 1.0
 */

@Controller
public class ExternalApiController {

    // 外部接口的 URL 路径以 /external/ 作为前缀

    @GetMapping("/external/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello stranger");
    }
}