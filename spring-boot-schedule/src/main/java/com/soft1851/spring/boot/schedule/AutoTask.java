package com.soft1851.spring.boot.schedule;

import com.soft1851.spring.boot.schedule.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNameAutoTask
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 */
//@Slf4j
//
//@Configuration
//public class AutoTask implements SchedulingConfigurer {
//    @Resource
//    private CronRepository cronRepository;
//
//    private String newCron;
//    private Integer cronId = 1;
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(
//                //1.添加任务内容(Runnable)
//                () -> {
////                    log.info("执行定时任务: " + LocalDateTime.now().toLocalTime())
//                },
//                //2.设置执行周期(Trigger)
//                triggerContext -> {
//                    //2.1 从数据库获取执行周期
//                    String cron = cronRepository.findCronByCronIdEquals(cronId).getCron();
//                    //2.2 合法性校验.
//                    if (StringUtils.isEmpty(cron)) {
//                        log.info("cron不能为空");
//                    }
//                    //2.3 返回执行周期
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }
//}
