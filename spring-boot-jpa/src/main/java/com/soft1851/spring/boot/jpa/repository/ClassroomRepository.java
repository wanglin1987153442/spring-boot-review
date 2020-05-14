package com.soft1851.spring.boot.jpa.repository;


import com.soft1851.spring.boot.jpa.model.Classroom;
import com.soft1851.spring.boot.jpa.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wl
 * @ClassNameClassRoomRepository
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Query(value = "select  u.id as id, u.age as age, u.email as email, u.nick_name as nickName, u.reg_time as regTime, u.user_name as userName,b.class_name as className from User u left join classroom b ON u.class_id=b.id  where b.id=?1",nativeQuery = true)
    List<UserVo> findUserByCLASSName(Long id);
}
