package com.bupt.travel.service;

import com.bupt.travel.model.requestBean.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void regiterIm() {
        UserBean userBean = new UserBean();
        userBean.setPhone("13120171898");
        userBean.setPassword("123456");
        userBean.setName("涂印");
        System.out.println(userService.regiterIm(userBean));
    }
}