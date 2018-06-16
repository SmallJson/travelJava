package com.bupt.travel.mapper;

import com.bupt.travel.model.Traffic;
import com.bupt.travel.model.requestBean.TrafficBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TrafficMapper {

    @Insert({"insert into traffic(id,start_time,flight,start_place,end_place) " +
            "values(#{id},#{startTime},#{flight},#{startPlace},#{endPlace}) " +
            "on duplicate key update start_time =#{startTime},flight=#{flight}," +
            "start_place=#{startPlace},end_place=#{endPlace}"})
    public  int inertTraffic(Traffic traffic);

    @Select("select start_time,flight, start_place, end_place from traffic where id = #{id}")
    @Results({
            @Result(property = "startTime" ,column = "start_time"),
            @Result(property = "flightName", column = "flight"),
            @Result(property = "endPlace", column ="end_place"),
            @Result(property = "startPlace", column = "start_place")
    })
    public TrafficBean selectTraffic(Integer id);
}
