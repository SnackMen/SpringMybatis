package com.ws.dao;

import com.ws.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)//spring单元测试
@ContextConfiguration({"classpath:spring/spring-*.xml"})//上下文配置
public class UserDaoTest {
    @Autowired
    private UserDao userDao;//初始化dao层面向接口

    /**
     * 添加用户单元测试，添加成功与否都有相应提示
     */
    @Test
    public void testAdd() {
        User user = new User();
        user.setLoginId("pc147852369");
        user.setName("雨下一整夜");
        user.setPwd("123456");
        user.setSex("未知");
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加用户失败");
        }
        if (result>0)
            System.out.println("添加用户成功");
    }

    @Test
    public void testFindOneId() throws Exception {
        User user = new User();
        user.setLoginId("pc147852369");
        User result = null; //受影响的行数默认为0
        try {
            result = userDao.findOneById(user.getLoginId());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查找用户失败");
        }
        if (null!=result)
            System.out.println("查找用户成功\n"+result.toString());
    }

    @Test
    public void testDel() {
        User user = new User();
        user.setLoginId("pc147852369");
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除用户失败");
        }
        if (result>0)
            System.out.println("删除用户成功");
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setLoginId("pc147852369");
        user.setName("手把手教程");
        user.setPwd("123456");
        user.setSex("男");
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新用户信息用户失败");
        }
        if (result>0)
            System.out.println("更新用户信息用户成功");

    }
}