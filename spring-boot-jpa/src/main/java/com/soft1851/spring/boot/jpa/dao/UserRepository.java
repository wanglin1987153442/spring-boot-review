package com.soft1851.spring.boot.jpa.dao;


import com.soft1851.spring.boot.jpa.model.cascade.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wl
 * @ClassNameUserRepository
 * @Description TODO
 * @Date 2020/5/12
 * @Version 1.0
 */
public interface  UserRepository extends JpaRepository<User, Integer> {

/**
 * 根据我定义的字段 来查询数据
 * 注意方法名
 *
 */
@Transactional(rollbackFor = RuntimeException.class)
List<User> findByPassword(String password);
    /**
     * 修改用户名
     *
     * @param userName
     * @param Id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE User SET username = ?1 WHERE id = ?2", nativeQuery = true)
    int updateName(String userName, int Id);




    /**
     * 分页查询用户
     *
     * @param username
     * @param pageable
     * @return
     */
    @Query("SELECT m FROM User m WHERE m.username=?1")
    Page<User> findByName(String username, Pageable pageable);

    /**
     * 插入用户
     *
     * @param password
     * @param username
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "INSERT INTO User(password, username) VALUES (:password, :username)", nativeQuery = true)
    Integer insertUser(@Param("password") String password, @Param("username") String username);
}

