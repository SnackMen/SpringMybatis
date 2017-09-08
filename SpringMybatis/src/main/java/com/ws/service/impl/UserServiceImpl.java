package com.ws.service.impl;

import com.sun.tools.javac.util.List;
import com.ws.dao.UserDao;
import com.ws.exception.*;
import com.ws.service.UserService;
import com.ws.utils.StringUtils;
import com.ws.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void add(User user) throws UserCanNotBeNullException, UserAireadyExistException, UserNameCanNotBeNullException, UserPwdCanNotBeNullException, OtherThingsException {

        //检查用户为空自定义异常
        if(null == user)
            throw new UserCanNotBeNullException("User can not be Null");

        //用户名不能为空检查
        if(StringUtils.isEmpty(user.getLoginId()))
            throw new UserNameCanNotBeNullException("User name can not be null");

        //用户密码不能为空检查
        if(StringUtils.isEmpty(user.getPwd()))
            throw new UserPwdCanNotBeNullException("User password can not be null");

        //由于我这个是仓库管理系统，根据业务需求来说，我们的用户基本信息都是不能为空的
        //基本信息包括：姓名、年龄、用户名、密码、性别、手机号，年龄大于18
//        if (StringUtils.isEmpty(user.getDuty())
//                || StringUtils.isEmpty(user.getSex())
//                || user.getAge() > 18
//                || StringUtils.isEmpty(user.getCellNumber())) {
//            //其他综合异常
//            throw new OtherThingsException("Some use's base info can not be null");
//        }
        //已经存在相同用户
        if (null != userDao.findOneById(user.getLoginId())) {
            //存在相同的用户异常
            throw new UserAireadyExistException("Register User Failed，Because the  user Aiready exist");
        }
        int result = 0; //受影响的行数默认为0
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            System.out.println("添加用户失败,用户已经存在");
            //其他用户添加失败异常
            throw new OtherThingsException(e);
        }
        if (result > 0)
            System.out.println("添加用户成功");
    }

    public void delete(User user) throws Exception {

    }

    public void update(User user) throws Exception {

    }

    @Cacheable(value = "testId", key = "'id_'+#Id")
    public User findOneById(Serializable Id) throws Exception {
        System.out.println("serviceImpl findOneById");
        return userDao.findOneById(Id);
    }

    public List<User> findAll() throws Exception {
        return null;
    }

    public User findUser(User user) throws Exception {
        return null;
    }
}
