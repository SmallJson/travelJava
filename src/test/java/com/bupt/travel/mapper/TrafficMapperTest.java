package com.bupt.travel.mapper;

import com.bupt.travel.model.Traffic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrafficMapperTest {

    @Autowired
    TrafficMapper trafficMapper;
    @Test
    public void inertTraffic() {
        Traffic traffic = new Traffic();
        traffic.setId(3);
        traffic.setStartPlace("北京");
        traffic.setEndPlace("上海");
        traffic.setFlight("T18");
        traffic.setStartTime("2017-11-08");
        trafficMapper.inertTraffic(traffic);
    }
}