package com.soft1851.spring.boot.schedule.service.servicimpl;

import cn.hutool.core.io.FileUtil;
import com.soft1851.spring.boot.schedule.model.Cron;
import com.soft1851.spring.boot.schedule.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNameAsyncTaskService1
 * @Description TODO
 * @Date 2020/5/17
 * @Version 1.0
 */
@Service
@Slf4j
public class AsyncTaskService1 {
@Resource
    CronRepository cronRepository;
    @Async
    public void   asyncTest(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Cron cron= cronRepository.findCronByCronIdEquals(1);
        log.info(String.valueOf(cron));
        cronRepository.updateCron(cron.getCron(),cron.getCronId());

    }


}
