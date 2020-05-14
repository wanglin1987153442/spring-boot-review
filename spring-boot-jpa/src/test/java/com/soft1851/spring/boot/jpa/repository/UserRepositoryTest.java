package com.soft1851.spring.boot.jpa.repository;

import com.soft1851.spring.boot.jpa.model.Classroom;
import com.soft1851.spring.boot.jpa.model.Course;
import com.soft1851.spring.boot.jpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    /**
     * 建表
     */
    public void sava() {


        List<User> users = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            Random random = new Random();
            int r = random.nextInt(4) + 1;
            Classroom classroom = Classroom.builder().id((long) r).build();

            User testUser = User.builder()
                    .userName("user" + i)
                    .email("user" + i + "@qq.com")
                    .password("123456")
                    .nickName("nickName" + i)

                    .age(new Random().nextInt(50))
                    .regTime(LocalDateTime.now()).build();
            users.add(testUser);
        }

        userRepository.saveAll(users);


    }

    @Test
    public void oneToOne() {
        User userByIdEquals = userRepository.findUserByIdEquals(1);
        System.out.println(userByIdEquals);
    }

@Resource
private  CourseRepository courseRepository;
    @Test
    public void manyToMant() {
        User userByIdEquals = userRepository.findUserByIdEquals(1);
        System.out.println(userByIdEquals);


//        Course course = courseRepository.findCourseByCourseName("SpringBoot");
//        System.out.println(course);
    }

    @Test
    public void search() {
        List<User> byEmailLike = userRepository.findByEmailLike("%user%");
        System.out.println(byEmailLike.size());
    }

    @Test
    public void sort() {

        List<User> id = userRepository.findAll(Sort.by("id"));
    }

    @Test
    public void UpdateUser() {
        //使用save活saveAndFlush方法更新数据，必须要提供所有字段值，否则该字段为空
        User user = User.builder()
                .id(1L)
                .userName("aaa修改")
                .email("aaa@qq.com")
                .password("aaa123修改")
                .nickName("aaa修改昵称")
                .age(12)
                .regTime(LocalDateTime.now()).build();
        userRepository.saveAndFlush(user);
        int i = userRepository.updateNickName("aaaav", 1);
        System.out.println(i);

    }

    @Test
    public void insert() {
        //自定义插入
        int n = userRepository.insertUser("hello", "hello123", "hello@qq.com");
        assertEquals(1, n);
    }

    @Test
    public void select() {
        User byId = userRepository.findById(1);
        System.out.println(byId);
    }

    @Test
    public void fenye() {
        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<User> pageInfo = userRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "id"));
        log.info("总记录数： {}", pageInfo.getTotalElements());
        log.info("当前页记录数： {}", pageInfo.getNumberOfElements());
        log.info("每页记录数： {}", pageInfo.getSize());
        log.info("获取总页数： {}", pageInfo.getTotalPages());
        log.info("查询结果： {}", pageInfo.getContent());
        log.info("当前页（从0开始计）： {}", pageInfo.getNumber());
        log.info("是否为首页： {}", pageInfo.isFirst());
        log.info("是否为尾页： {}", pageInfo.isLast());
        // 条件查询
        User user = User.builder().userName("user1").build();
        List<User> users = userRepository.findAll(Example.of(user));
        log.info("满足条件的记录有：");
        users.forEach(user1 -> log.info(user1.toString()));
        // 单个查询
        User user1 = User.builder().id(2L).build();
        Optional<User> optionalUser = userRepository.findOne(Example.of(user1));
        log.info("单个查询结果： {}", optionalUser.orElse(null));
    }

}


