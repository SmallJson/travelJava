package com.bupt.travel.mapper;

import com.bupt.travel.model.TravelTotal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelTotalMapperTest {

    @Autowired
    TravelTotalMapper travelTotalMapper;

    @Test
    public void insertTravelTotal() {
        TravelTotal travelTotal = new TravelTotal();
        travelTotal.setFromUid(3);
        travelTotal.setToUid(8);
        travelTotal.setReadType(1);
        travelTotal.setCreatTime(System.currentTimeMillis()+"");
        travelTotal.setType(1);
        travelTotal.setTravelName("hello");
        travelTotal.setStartTime("2017");
        travelTotal.setStartPlace("北京");
        travelTotal.setTravelDay(11);
        travelTotalMapper.insertTravelTotal(travelTotal);
        System.out.println("查询的自增长主键:"+travelTotal.id);
    }

    @Test
    public void selectTravleTotalByFromUid(){
        System.out.println(travelTotalMapper.selectXingchengIdByFromUid(3,6,null,null));
    }
}