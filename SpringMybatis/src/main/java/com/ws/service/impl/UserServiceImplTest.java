package com.ws.service.impl;

import com.ws.exception.*;
import com.ws.service.UserService;
import com.ws.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class UserServiceImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testAdd(){
        User user = new User();
        user.setLoginId("13121362");
        user.setName("laowang");
        user.setPwd("test");
        user.setSex("男");
        user.setAge(22);
        user.setCellNumber("12131213121");
        user.setUsed(true);
        user.setDuty("student");
        user.setPhotoUrl("www.baidu.com");
        try{
            userService.add(user);
        }catch (UserCanNotBeNullException e){
            e.printStackTrace();
        }catch (UserNameCanNotBeNullException e){
            e.printStackTrace();
        }catch (UserPwdCanNotBeNullException e){
            e.printStackTrace();
        }catch (UserAireadyExistException e){
            e.printStackTrace();
        }catch (OtherThingsException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUser() throws Exception {
        User user = userService.findOneById("13121362");
        System.out.println(user.getAge());
        System.out.println(user.getSex());
    }

}