package com.soft1851.spring.boot.schedule.quartz;

import org.quartz.SchedulerException;

/**
 * @author wl
 * @ClassNameDynamicScheduleTask
 * @Description 动态调度任务
 * @Date 2020/5/18
 * @Version 1.0
 */

    public class DynamicScheduleTask {
        public static void main(String[] args)throws SchedulerException {
            //添加任务，注意各个参数的作用
            QuartzManager.addJob("testJob", "jobGroup1",
                    "testTrigger", "triggerGroup1",
                    TestJob.class, 2);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //修改任务
            QuartzManager.modifyJobTime("testTrigger", "triggerGroup1",
                    5);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //删除任务
            QuartzManager.removeJob("testJob", "jobGroup1",
                    "testTrigger", "triggerGroup1");

            QuartzManager.shutdownJobs();
        }
    }