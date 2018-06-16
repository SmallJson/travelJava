package com.bupt.travel;

import com.bupt.travel.mapper.UserMapper;
import com.bupt.travel.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelApplicationTests {
	@Autowired
	public UserMapper mapper;
	@Test
	public void contextLoads() {

	}

	@Test
	public void insert(){
			User user =new  User();
			user.setAccount("parent");
			user.setPassword("123456");
			mapper.insert(user);
	}
}
