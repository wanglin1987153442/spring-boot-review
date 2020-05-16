package com.soft1851.spring.boot.schedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class MailServiceTest {
    @Resource
    private  MailService mailService;
    @Test
    void sendSimpleTextMail() {
        String to ="727846506@qq.com";
        String subjiect="你好 这是我用java发的邮件";
        String content="<h3>这是一封spring实现的邮件</h3>";
        mailService.sendSimpleTextMail(to,subjiect,content);
    }

    @Test
    void sendSimpleHtmlMail()throws Exception {
        String to ="727846506@qq.com";
        String subjiect="你好 这是我用java发的邮件";
        String content="<h3>这是一封spring实现的邮件</h3>";
        mailService.sendSimpleHtmlMail(to,subjiect,content);
    }



    @Test
    void sendAttachmentMail() throws MessagingException {
        String to ="727846506@qq.com";
        String subject = "Spring Boot 发送HTML标签邮件";
        String content = "<h3>第一封 Springboot <strong>HTML</strong>邮件</h3>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to, subject, content, filePath);
    }

    @Test
    void sendImgMail() throws MessagingException {
        String to ="727846506@qq.com";
        String subject = "Spring Boot 发送图片邮件";
        String content = "<h3>第一封 Springboot <img src=\"cid:img01\" />图片邮件</h3>";
        String imgPath = "C:\\Users\\林小派\\Desktop\\1.jpg";
        Map<String, String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
    }

}