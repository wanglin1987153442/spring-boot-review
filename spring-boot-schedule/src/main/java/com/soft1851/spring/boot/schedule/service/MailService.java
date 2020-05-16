package com.soft1851.spring.boot.schedule.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author wl
 * @ClassNameMailService
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 */
public interface MailService {
    /**
     * 发送简单文本邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTextMail(String to,String subject,String content);

    /**
     * html邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleHtmlMail(String to,String subject,String content)throws MessagingException;


    /**
     * 发送有附件邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     */
    void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException;

    /**
     * 发送图片邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param imgMap
     * @throws MessagingException
     */
    void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException;
}

