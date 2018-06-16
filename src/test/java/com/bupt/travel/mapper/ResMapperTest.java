package com.bupt.travel.mapper;

import com.bupt.travel.model.Res;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResMapperTest {
    @Autowired
    ResMapper resMapper;
    @Test
    public void insertRes() {
        Res res = new Res();
        res.id = 3;
        res.resName ="香格里拉大酒店";
        res.resAddress="西土城路10号";
        resMapper.insertRes(res);
    }
}