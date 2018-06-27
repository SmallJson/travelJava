package com.bupt.travel.mapper;

import com.bupt.travel.model.TravelDay;
import com.bupt.travel.model.requestBean.TravelDayBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TravelDayMapper {

    @Insert("insert into travel_day(day,xingcheng_id) values(#{day},#{xingchengId}) " +
            "on duplicate key update day=#{day},xingcheng_id=#{xingchengId}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
     public Integer insertTravelDay(TravelDay travelDay);

    @Select("select id from travel_day where day =#{day} AND xingcheng_id =#{xingchengId}")
    @Results({
        @Result(property = "trafficBean",column = "id",
                one = @One(select = "com.bupt.travel.mapper.TrafficMapper.selectTraffic")),
        @Result(property = "resBean",column = "id",
                    one = @One(select = "com.bupt.travel.mapper.ResMapper.selectRes")),
        @Result(property = "placeBean",column = "id",
                    one = @One(select = "com.bupt.travel.mapper.PlaceMapper.selectPlace")),
        @Result(property = "houseBean",column = "id",
                    one = @One(select = "com.bupt.travel.mapper.HouseMapper.selectHouse")),
        @Result(property = "noteBean", column = "id",
                    one = @One(select = "com.bupt.travel.mapper.NoteMapper.selectNode"))
    })
    public TravelDayBean selectTravelDay(TravelDay travelDay);
}
