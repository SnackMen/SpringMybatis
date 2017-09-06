package com.ws.service;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

public interface BaseService<T> {

    /**
     * 添加用户实例
     * @param t 用户实例
     * @throws Exception
     */
    void add(T t)throws Exception;

    /**
     * 删除用户实例
     * @param t
     * @throws Exception
     */
    void delete(T t)throws Exception;

    /**
     * 更新用户实例
     * @param t
     * @throws Exception
     */
    void update(T t)throws Exception;

    /**
     * 通过id查找
     * @param Id
     * @return
     * @throws Exception
     */
    T findOneById(Serializable Id)throws Exception;

    /**
     * 查询所有数据集合
     * @return
     */
    List<T> findAll() throws Exception;

    /**
     * 查询用户信息
     * @param t
     * @return
     * @throws Exception
     */
    T findUser(T t) throws Exception;

}
