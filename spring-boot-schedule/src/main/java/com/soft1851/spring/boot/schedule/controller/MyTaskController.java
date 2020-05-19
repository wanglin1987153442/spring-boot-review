package com.soft1851.spring.boot.schedule.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.http.HttpUtil;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.soft1851.spring.boot.schedule.model.Cron;
import com.soft1851.spring.boot.schedule.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * @author wl
 * @ClassNameasda
 * @Description TODO
 * @Date 2020/5/16
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/cron")
@Slf4j
public class MyTaskController {

    @Resource
    protected CronRepository cronRepository;

    /**
     * 线程池任务调度类，能够开启线程池进行任务调度。
     */

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    /**
     * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，
     * 在这个方法需要添加两个参数，Runnable（线程接口） 和CronTrigger（定时任务触发器）
     */
    ScheduledFuture<?> future;

    @GetMapping("/start")
    public String start() {
        String cron = cronRepository.findCronByCronIdEquals(1).getCron();
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron));
        log.info("定时任务启动");
        return "定时任务启动";
    }

    @GetMapping("/stop")
    public String stopCron() {
        if (future != null) {
            future.cancel(true);
        }
        log.info("定时任务停止");
        return "定时任务停止";
    }

    @PostMapping("/change")
    public String updateCron(@RequestBody Cron cron) {
        stopCron();
        System.out.println(cron);
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron.getCron()));
        cronRepository.updateCron(cron.getCron(), cron.getCronId());
        return "修改定时任务设置";
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {

            List<Cron> crons = cronRepository.findAll();

            int index = RandomUtil.randomInt(0, crons.size());
            log.info(String.valueOf(index));
            Cron cron = crons.get(index);
            download(cron);
        }
    }


    @Async
    public void download(Cron cron) {
        String template = "F:/test/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());
        log.info(path);
//将文件下载后保存在E盘，返回结果为下载文件大小
        long l = HttpUtil.downloadFile(cron.getImg(), FileUtil.file(path));

        getErWeiMa(cron);
    }

    @Async
    public void getErWeiMa(Cron cron) {
        QrConfig config = new QrConfig(300, 300);
// 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
// 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
// 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        String template = "F:/test/{}.jpg";
        String path = StrUtil.format(template, IdUtil.simpleUUID());

// 生成二维码到文件，也可以到流
        QrCodeUtil.generate(cron.getGithub(), config, FileUtil.file(path));


    }
}