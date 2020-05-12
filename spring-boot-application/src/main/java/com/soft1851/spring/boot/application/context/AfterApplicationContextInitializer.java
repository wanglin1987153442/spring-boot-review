package com.soft1851.spring.boot.application.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @author wl
 * @ClassName AfterApplicationContextInitializer
 * @Description TODO
 * @Date 2020/5/12
 * @Version 1.0
 */
@Slf4j
public class AfterApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C>, Ordered {


    @Override
    public void initialize(C applicationContext) {
        log.info("After Application.id = " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}