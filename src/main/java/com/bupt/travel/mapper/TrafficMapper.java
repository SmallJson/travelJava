package com.bupt.travel.mapper;

import com.bupt.travel.model.Traffic;
import com.bupt.travel.model.requestBean.TrafficBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TrafficMapper {

    @Insert({"insert into traffic(id,start_time,flight,start_place,end_place,complete,img) " +
            "values(#{id},#{startTime},#{flight},#{startPlace},#{endPlace},#{complete},#{img}) " +
            "on duplicate key update start_time =#{startTime},flight=#{flight}," +
            "start_place=#{startPlace},end_place=#{endPlace}"})
    public  int inertTraffic(Traffic traffic);

    @Select("select * from traffic where id = #{id}")
    @Results({
            @Result(property = "startTime" ,column = "start_time"),
            @Result(property = "flightName", column = "flight"),
            @Result(property = "endPlace", column ="end_place"),
            @Result(property = "startPlace", column = "start_place")
    })
    public TrafficBean selectTraffic(Integer id);

    @Insert("update traffic set complete = #{complete} where id = #{id}")
    public int updateComplete(@Param("id") Integer id, @Param("complete") Integer complete);
}
