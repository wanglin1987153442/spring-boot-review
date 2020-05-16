package com.soft1851.spring.boot.schedule.service.servicimpl;

import com.soft1851.spring.boot.schedule.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * @author wl
 * @ClassNameMailServiceImpl
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {


    /**
     * 读入配置文件中的邮箱发送者设置
     */
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        javaMailSender.send(message);
        log.info("文本邮件成功发送！ to={}", to);
    }

    @Override
    public void sendSimpleHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        //true 为 html 邮件
        messageHelper.setText(content,true);
        javaMailSender.send(mimeMessage);
        log.info("[HTML邮件]发送成功！to={}",to);




    }




    @Override
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);

        //添加图片
        for (Map.Entry<String, String> entry : imgMap.entrySet()) {
            FileSystemResource fileSystemResource = new FileSystemResource(new File(entry.getValue()));
            if (fileSystemResource.exists()) {
                mimeMessageHelper.addInline(entry.getKey(), fileSystemResource);
            }
        }
        javaMailSender.send(mimeMessage);
        log.info("图片邮件发送成功! to = {}", to);
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        //添加附件
        for (String filePath : fileArr) {
            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            if (fileSystemResource.exists()) {
                String fileName = fileSystemResource.getFilename();
                assert fileName != null;
                messageHelper.addAttachment(fileName, fileSystemResource);
            }
        }
        javaMailSender.send(mimeMessage);
        log.info("附件邮件发送成功！ to = {}", to);
    }

}
