package com.bupt.travel.dao;

import com.bupt.travel.mapper.*;
import com.bupt.travel.model.*;
import com.bupt.travel.model.requestBean.TravelDayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Autowired
    NoteMapper noteMapper;
    public void insertTravel(TravelTotal travelTotal){
        travelTotalMapper.insertTravelTotal(travelTotal);
    }

    public List<TravelTotal> selectTravel(Integer fromId, Integer toId, Integer type, Integer readType){
        return travelTotalMapper.selectTravelByFromUid(fromId,toId,type,readType);
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

    public void insertNote(Note note){
        noteMapper.insertNote(note);
    }

    public TravelTotal selectTraveTotalById(Integer travelId){
        return  travelTotalMapper.selectTravelByXingchengId(travelId);
    }

    /**
     * 更新住宿信息完成度
     * @param id
     * @param complete
     * @return
     */
    public  int updateHouseComplete(int id , int complete){
        return houseMapper.updateComplete(id ,complete);
    }

    /**
     * 更新地点信息完成度
     * @param id
     * @param complete
     * @return
     */
    public  int updatePlaceComplete(int id , int complete){
        return placeMapper.updateComplete(id ,complete);
    }

    /**
     * 更新交通信息完成度
     * @param id
     * @param complete
     * @return
     */
    public  int updateTrafficComplete(int id , int complete){
        return trafficMapper.updateComplete(id ,complete);
    }

    /**
     * 更新餐馆信息完成度
     * @param id
     * @param complete
     * @return
     */
    public  int updateResComplete(int id , int complete){
        return resMapper.updateComplete(id ,complete);
    }
}
