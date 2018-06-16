package com.bupt.travel.mapper;

import com.bupt.travel.model.Place;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaceMapperTest {
    @Autowired
    PlaceMapper placeMapper;
    @Test
    public void insertPlace() {
        Place place =new Place();
        place.setId(3);
        place.setPlaceName("北京天坛");
        place.setPlayTime("呼家楼10号");
        placeMapper.insertPlace(place);
    }
}