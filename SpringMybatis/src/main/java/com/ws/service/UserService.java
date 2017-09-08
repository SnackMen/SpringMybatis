package com.ws.service;

import com.sun.tools.javac.util.List;
import com.ws.vo.User;


import java.io.Serializable;

public interface UserService extends BaseService<User> {

    void add(User user) throws Exception;

    void delete(User user) throws Exception;

    void update(User user) throws Exception;

    User findOneById(Serializable Id) throws Exception;

    List<User> findAll() throws Exception;

    User findUser(User user) throws Exception;
}
