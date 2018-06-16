package com.bupt.travel.mapper;

import com.bupt.travel.model.TravelDay;
import com.bupt.travel.model.requestBean.TravelDayBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelDayMapperTest {
    @Autowired
    public TravelDayMapper travelDayMapper;
    @Test
    public void insertTravelDay() {
        TravelDay travelDay = new TravelDay();
        travelDay.setDay(1);
        travelDay.setXingchengId(11);
        travelDayMapper.insertTravelDay(travelDay);
        System.out.println("自增长主键="+travelDay.getId());
    }

    @Test
    public void selectTravelDay(){
        TravelDay travelDay = new TravelDay();
        travelDay.setDay(1);
        travelDay.setXingchengId(11);
        TravelDayBean travelDayBean = travelDayMapper.selectTravelDay(travelDay);
        System.out.println(travelDayBean);
    }
}