package com.soft1851.spring.boot.jpa.repository;

import com.soft1851.spring.boot.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wl
 * @ClassNameCourseRepository
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */
public interface CourseRepository extends JpaRepository<Course ,Long> {


@Query(value = "select id, course_name, teacher_id from course  where teacher_id=?1 ",nativeQuery = true)
    List<Course>selcetCourseList(long id);

    Course findCourseByCourseName(String courseName);

}
