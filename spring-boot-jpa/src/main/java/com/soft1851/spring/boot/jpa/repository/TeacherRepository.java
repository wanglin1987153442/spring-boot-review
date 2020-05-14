package com.soft1851.spring.boot.jpa.repository;

import com.soft1851.spring.boot.jpa.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author wl
 * @ClassNameTeacherRepository
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    /**
     * 一对多的方法
     */
    Teacher findByIdEquals(Long Id);



}
