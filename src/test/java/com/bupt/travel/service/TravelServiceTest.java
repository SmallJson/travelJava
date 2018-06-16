package com.bupt.travel.service;

import com.bupt.travel.model.requestBean.TravelTotalBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelServiceTest {
    @Autowired
    TravelService travelService;
    @Test
    public void insertTravel() {

    }

    @Test
    public void selectTravel() {
        List<TravelTotalBean> list =   travelService.selectTravel(3,null,null,null);
        System.out.println(list);
    }
}