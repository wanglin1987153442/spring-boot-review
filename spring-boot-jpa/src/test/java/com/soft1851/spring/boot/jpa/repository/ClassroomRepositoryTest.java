package com.soft1851.spring.boot.jpa.repository;


import com.soft1851.spring.boot.jpa.model.Classroom;
import com.soft1851.spring.boot.jpa.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest

class ClassroomRepositoryTest {
    @Resource
    private ClassroomRepository classroomRepository;

    @Test
    public void save() {
        List<Classroom> classrooms = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Classroom classroom = Classroom.builder().className("soft185" + i).build();
            classrooms.add(classroom);
        }
        classroomRepository.saveAll(classrooms);
    }


    @Test
    void findUserByCLASSName() {
        List<UserVo> userByCLASSName = classroomRepository.findUserByCLASSName(1L);
//        userByCLASSName.forEach(System.out::println);
        for(UserVo userVo:userByCLASSName){
            System.out.println(userVo.getClassName());
        }
        System.out.println(userByCLASSName.size());
    }
}