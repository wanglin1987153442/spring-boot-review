package com.soft1851.spring.boot.jpa.repository;

import com.soft1851.spring.boot.jpa.model.Course;
import com.soft1851.spring.boot.jpa.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class TeacherRepositoryTest {
    @Resource
    private TeacherRepository teacherRepository;

    @Test
    public void save() {
        List<Teacher> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Teacher teacher = Teacher.builder().account("teacher" + i).password("teacher").build();
            list.add(teacher);
        }
        teacherRepository.saveAll(list);
    }

@Resource
CourseRepository courseRepository;
    @Test
    public void oneToMany() {
         //饿汉式操作
//        Teacher byIdEquals = teacherRepository.findByIdEquals((long) 1);
//        System.out.println(byIdEquals);
        //懒汉式操作多一层装配

        List<Course> courseList = courseRepository.selcetCourseList(1);
//        System.out.println(courseList);
        Teacher byIdEquals = teacherRepository.findByIdEquals((long) 1);
        byIdEquals.setCourseList(courseList);
        System.out.println(byIdEquals);
    }
}