package com.soft1851.spring.boot.jpa.dao;

import com.soft1851.spring.boot.jpa.model.cascade.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    public void saveUser() {
        User user = User.builder().password("123").username("王林").build();
        userRepository.save(user);
        List<User> users = new ArrayList<>(Arrays.asList(
                User.builder().password("123").username("王林1").build(),
                User.builder().password("123").username("王林2").build(),
                User.builder().password("123").username("王林3").build(),
                User.builder().password("123").username("王林4").build()));
        // 保存多个
        userRepository.saveAll(users);

    }


    @Test
    @Transactional
    void findByUsername() {
        List<User> wl = userRepository.findByPassword("123");
        wl.forEach(System.out::println);

    }

    @Test
    void updateName() {
        userRepository.updateName("王林林林林", 1);
    }


    @Test
    void insertUser() {
        userRepository.insertUser("121", "王林林");
    }
}