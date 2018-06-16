package com.bupt.travel.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateUtilTest {
    @Autowired
    RestTemplateUtil restTemplateUtil;
    @Test
    public void doPostWithImage() {
            restTemplateUtil.doPostWithImage("https://a1.easemob.com/1148180614146538/travel/chatfiles",
                    "C:\\Users\\Administrator\\AppData\\Local\\Temp\\tomcat-docbase.2358809923873806272.8080\\1529037303376test.png");
    }
}