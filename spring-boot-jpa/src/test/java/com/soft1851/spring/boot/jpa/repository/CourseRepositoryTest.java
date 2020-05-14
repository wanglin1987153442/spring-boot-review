package com.soft1851.spring.boot.jpa.repository;

import com.soft1851.spring.boot.jpa.model.Course;
import com.soft1851.spring.boot.jpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class CourseRepositoryTest {
    @Resource
    private CourseRepository courseRepository;

    @Test
    public void save() {
        List<Course> courseList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            Random random = new Random();
            int n = random.nextInt(4) + 1;
            Teacher teacher = Teacher.builder().id((long) n).build();
            Course course = Course.builder().courseName("软件开发" + i).build();
            courseList.add(course);
        }
        courseRepository.saveAll(courseList);
    }
}