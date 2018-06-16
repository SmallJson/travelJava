package com.bupt.travel.dao;

import com.bupt.travel.mapper.*;
import com.bupt.travel.model.*;
import com.bupt.travel.model.requestBean.HouseBean;
import com.bupt.travel.model.requestBean.TravelDayBean;
import com.bupt.travel.model.requestBean.TravelTotalBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TravelDao {
    @Autowired
    TravelTotalMapper travelTotalMapper;
    @Autowired
    TravelDayMapper travelDayMapper;
    @Autowired
    TrafficMapper trafficMapper;
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    PlaceMapper placeMapper;
    @Autowired
    ResMapper resMapper;
    public void insertTravel(TravelTotal travelTotal){
        travelTotalMapper.insertTravelTotal(travelTotal);
    }

    public List<TravelTotal> selectTravel(Integer fromId, Integer toId, Integer type, Integer readType){
        return travelTotalMapper.selectXingchengIdByFromUid(fromId,toId,type,readType);
    }

    public int updateTravelDay(TravelTotal travelTotal){
        return  travelTotalMapper.updateTravelTotal(travelTotal);
    }

    public void insertTravelDay(TravelDay travelDay){
        travelDayMapper.insertTravelDay(travelDay);
    }


    public TravelDayBean selectTravelDay(TravelDay travelDay){
        return travelDayMapper.selectTravelDay(travelDay);
    }

    public void insertTraffic(Traffic traffic){
        trafficMapper.inertTraffic(traffic);
    }


    public void insertPlace(Place place){
        placeMapper.insertPlace(place);
    }

    public void insertRes(Res res){
        resMapper.insertRes(res);
    }

    public void insertHouse(House house){
        houseMapper.insertHouse(house);
    }
}
