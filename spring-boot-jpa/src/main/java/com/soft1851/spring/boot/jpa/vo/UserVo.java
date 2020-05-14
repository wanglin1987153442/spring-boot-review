package com.soft1851.spring.boot.jpa.vo;

import java.time.LocalDateTime;

/**
 * @author wl
 * @ClassNameUserVO
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 */


public interface UserVo {

    Long getId();

    Integer getAge();

    String getEmail();

    String getNickName();

    LocalDateTime getRegTime();

    String getUserName();

    String getClassName();

}
