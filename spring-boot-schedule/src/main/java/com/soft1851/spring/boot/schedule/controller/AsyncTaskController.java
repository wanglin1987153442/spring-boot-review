package com.soft1851.spring.boot.schedule.controller;

import com.soft1851.spring.boot.schedule.service.AsyncTaskService;
import com.soft1851.spring.boot.schedule.service.servicimpl.AsyncTaskService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNameAsyncTaskController
 * @Description TODO
 * @Date 2020/5/16
 * @Version 1.0
 */
@RestController
@Slf4j
public class AsyncTaskController {
    @Resource
    private AsyncTaskService asyncTaskService;
@Resource
private AsyncTaskService1 asyncTaskService1;
    @RequestMapping("/asyncTask")
    public  String asyncTask(){
        asyncTaskService.asyncTask();
        return "测试异步任务...";
    }

    @RequestMapping("/asyncTest")
    public  String asyncTest(){
        asyncTaskService1.asyncTest();
        return "成功获取";
    }
}
