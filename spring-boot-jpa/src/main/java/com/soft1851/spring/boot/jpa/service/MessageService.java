package com.soft1851.spring.boot.jpa.service;

import com.soft1851.spring.boot.jpa.model.Message;

import java.util.List;

/**
 * @author wl
 * @ClassNamesad
 * @Description TODO
 * @Date 2020/5/12
 * @Version 1.0
 */
public interface MessageService {
    void save(Message message);

    void batchSave(List<Message> messages);

    void delete(Integer id);

    void batchDelete(List<Message> messages);

    void deleteAll();

    void update(Message message);

    void batchUpdate(List<Message> messages);

    long count();

    Message getMessage(Integer id);

    List<Message> getAll();
}
