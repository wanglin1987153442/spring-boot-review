package com.soft1851.spring.boot.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wl
 * @ClassNameTask
 * @Description TODO
 * @Date 2020/5/14
 * @Version 1.0
 */
//@Component

public class Task1 {
    private int count = 0;

    @Scheduled(cron = "*/5 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running " + (count++));
    }
}