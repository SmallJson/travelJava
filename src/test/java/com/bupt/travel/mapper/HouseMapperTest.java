package com.bupt.travel.mapper;

import com.bupt.travel.model.House;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseMapperTest {
    @Autowired
    HouseMapper houseMapper;
    @Test
    public void insertHouse() {
        House house = new House();
        house.setId(3);
        house.setHouseName("北邮科技酒店");
        house.setHouseAddress("西土城路路10号");
        houseMapper.insertHouse(house);
    }
}