package com.soft1851.spring.boot.application.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;

/**
 * @author wl
 * @ClassNameAfterApplicationListener
 * @Description AfterHelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 * @Date 2020/5/12
 * @Version 1.0
 */
@Order()
@Slf4j
public class AfterApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("After Hello World: " + event.getApplicationContext().getId() + ",timestamp: " + event.getTimestamp());
    }
}