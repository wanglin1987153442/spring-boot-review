package com.soft1851.gongcheng.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wl
 * @ClassNameda
 * @Description TODO
 * @Date 2020/5/17
 * @Version 1.0
 */
@Controller
public class InternalApiController {

    // 内部接口的 URL 路径以 /internal/ 作为前缀

    @GetMapping("/internal/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello friend");
    }
}