package com.ws.dao;

import com.sun.tools.javac.util.List;
import com.ws.vo.User;

import java.io.Serializable;

public interface UserDao extends Dao<User> {

    int add(User user);

    int delete(User user);

    int update(User user);

    User findOneById(Serializable Id);

    List<User> findAll();
}
