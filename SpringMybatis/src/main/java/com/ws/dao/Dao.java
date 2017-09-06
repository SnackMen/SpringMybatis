package com.ws.dao;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

public interface Dao<T> {

    /**
     * 添加某个对象
     * @param t 待添加对象
     * @return 返回受影响行数
     */
    int add(T t);

    /**
     * 删除某个对象
     * @param t 删除对象
     * @return 返回收影响行数
     */
    int delete(T t);

    /**
     * 更新某个对象
     * @param t 更新对象
     * @return 返回受影响行数
     */
    int update(T t);

    /**
     * 通过Id查找一个对象
     * @param Id 待查找对象id
     * @return 该id对应的对象
     */
    T findOneById(Serializable Id);

    /**
     * 查找对象集合
     * @return 返回对象集合
     */
    List<T> findAll();
}
