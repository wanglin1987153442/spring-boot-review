package com.soft1851.spring.boot.jpa.repository;

import com.soft1851.spring.boot.jpa.model.Teacher;
import com.soft1851.spring.boot.jpa.model.User;
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
 * @Date 2020/5/13
 * @Version 1.0
 */
interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 已经有继承的许多方法   我们需要添加自定义的一些方法
     *
     */
    /**
     *
     * 一对一实现方法
     * @param id
     * @return
     */
    User findUserByIdEquals(long id);

    /**
     * 多对多查询
     */


    /**
     * 查询用户
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * or
     *
     * @param username
     * @param email
     * @return
     */

   List< User> findByUserNameOrEmail(String username, String email);


    /**
     * equals
     *
     * @param userName
     * @return
     */
    User findByUserNameEquals(String userName);

    /**
     * like用法
     *
     * @param email
     * @return
     */

    List<User> findByEmailLike(String email);


    /**
     * 自定义JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param id
     * @return
     */
    @Query("select u from User u where u.id = ?1" )
    User findById(long id);

    /**
     * 按id修改nickName
     *
     * @param nickName
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update user set nick_name = ?1 where id = ?2", nativeQuery = true)
    int updateNickName(String nickName, long id);


    /**
     * 插入
     *
     * @param userName
     * @param password
     * @param email
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into user(user_name, password,email) values (:userName, :password,:email)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("email") String email);

}



