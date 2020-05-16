package com.soft1851.spring.boot.schedule.repository;

import com.soft1851.spring.boot.schedule.model.Cron;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CronRepositoryTest {
@Resource
private CronRepository cronRepository;
    @Test
    void findCronByCronIdEquals() {
        Cron cronByCronIdEquals = cronRepository.findCronByCronIdEquals(1);
        System.out.println(cronByCronIdEquals);
    }

    @Test
    void updateCron() {
        String cron="0/10 * * * * ?";
        int id=2;
        cronRepository.updateCron(cron,id);
    }
}