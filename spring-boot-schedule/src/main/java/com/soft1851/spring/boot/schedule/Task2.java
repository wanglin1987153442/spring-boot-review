package com.soft1851.spring.boot.schedule;

import com.soft1851.spring.boot.schedule.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wl
 * @ClassNameTask2
 * @Description TODO
 * @Date 2020/5/14
 * @Version 1.0
 */
//@Component
public class Task2 {

    @Resource
    private MailService mailService;

    @Scheduled(cron = "0/10 * * * * *")
    public void sendEmail()throws Exception {
        String to ="727846506@qq.com";
        String subjiect="你好 这是我用java发的邮件";
        String content="<h3>这是一封spring实现的邮件</h3>";
        mailService.sendSimpleHtmlMail(to, subjiect, content);
    }


//    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
//
//    @Scheduled(fixedRate = 3000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dtf.format(LocalDateTime.now()));
//    }
//
//
//    /**
//     * fixedRate:固定频率执行
//     */
//    @Scheduled(fixedRate = 3000)
//    public void reportCurrentTime1() {
//        System.out.println(Thread.currentThread().getName() + "现在时间：" + dtf.format(LocalDateTime.now()));
//    }
//
//    /**
//     * fixedDelay:固定延时
//     */
//    @Scheduled(fixedDelay = 2000)
//    public void reportCurrentTime2() {
//        System.out.println(Thread.currentThread().getName() + "现在时间：" + dtf.format(LocalDateTime.now()));
//    }
//
//    /**
//     * 第一次延迟3秒后执行，之后按fixedDelay的规则每2秒执行一次
//     */
//    @Scheduled(initialDelay = 3000, fixedDelay = 2000)
//    public void reportCurrentTime3() {
//        System.out.println(Thread.currentThread().getName() + "现在时间：" + dtf.format(LocalDateTime.now()));
//    }
//
//    /**
//     * 通过cron表达式定义规则
//     */
//    @Scheduled(cron = "0/5 * * * * *")
//    public void reportCurrentTime4() {
//        System.out.println("现在时间：" + dtf.format(LocalDateTime.now()));
//    }
}