package com.bupt.travel.service;

import com.bupt.travel.model.reponseBean.PhotoInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoServiceTest {
    @Autowired
    PhotoService photoService;
    @Test
    public void selectPhone() {

        List<PhotoInfo> list = photoService.selectPhone(112);
        System.out.println();
    }
}