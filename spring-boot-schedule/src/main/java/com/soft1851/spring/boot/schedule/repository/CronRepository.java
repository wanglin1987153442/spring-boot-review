package com.soft1851.spring.boot.schedule.repository;

import com.soft1851.spring.boot.schedule.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author wl
 * @ClassNameCronRepository
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 */
public interface CronRepository extends JpaRepository<Cron, Integer> {

    /**
     * 根据cronId查询
     *
     * @param cronId
     * @return
     */
    Cron findCronByCronIdEquals(int cronId);



    /**
     * 修改cron
     * @param cron
     * @param id
     */

    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update Cron set cron=?1 where cron_id=?2",nativeQuery = true)
    void updateCron(String cron,int id);

}

