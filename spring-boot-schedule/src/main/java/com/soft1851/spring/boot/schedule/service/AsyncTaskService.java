package com.soft1851.spring.boot.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wl
 * @ClassNameAsyncTaskService
 * @Description TODO
 * @Date 2020/5/16
 * @Version 1.0
 */
@Service
@Slf4j
public class AsyncTaskService {
    @Async
    public void   asyncTask(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
    }





}
