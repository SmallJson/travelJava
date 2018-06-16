package com.bupt.travel.mapper;

import com.bupt.travel.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    public UserMapper mapper;
    @Test
    public void insert(){
        User user =new  User();
        user.setAccount("18435134579");
        user.setPassword("1234556");
        mapper.insert(user);
    }

    @Test
    public void select() {
        User user = new User();
        user.setAccount("child");
        user.setPassword("123456");
        user = mapper.select(user);
        System.out.println(user.getUid());
    }
    @Test
    public void selectUid(){
        System.out.println(mapper.selectIdByPhone("13120171898"));
    }

    @Test
    public void selectUserInfoByUid(){
        System.out.println(mapper.selectUserInfoByUid(3));
    }
}