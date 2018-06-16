package com.bupt.travel.mapper;

import com.bupt.travel.model.TravelTotal;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

/*//行程唯一id
public Integer id;
//规划人
public Integer fromUid;
//被规划人
public Integer toUid;
//是否已读标识
public Integer read;
//行程创建时间
public String creatTime;
//行程类型
public Integer type;
public String travelName;
public  String startTime;
public  String startPlace;
public String travelDay;*/
@Mapper
public interface  TravelTotalMapper {
    //插入之后返回自增长主键id
    @Insert("insert into travel_total(from_uid,to_uid,read_type,creat_time,type,travel_name,start_time," +
            "start_place,travel_day) values(#{fromUid},#{toUid},#{readType},#{creatTime}," +
            "#{type},#{travelName},#{startTime},#{startPlace},#{travelDay})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Integer insertTravelTotal(TravelTotal travelTotal);


    //更新指定id的行程信息
    @Insert("update travel_total set read_type=#{readType}" +
            ",creat_time=#{creatTime},type=#{type},travel_name#{travelName},start_time=#{startTime}" +
            ",start_place=#{startPlace},travel_day=#{travelDay} where id =#{id}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Integer updateTravelTotal(TravelTotal travelTotal);


    @SelectProvider(type = TravelSqlProvider.class, method = "selectTravelByFromUid")
    @Results({
            @Result(property = "fromUid", column = "from_uid"),
            @Result(property = "toUid", column = "to_uid"),
            @Result(property = "readType", column = "read_type"),
            @Result(property = "creatTime",column = "creat_time"),
            @Result(property = "type",column = "type"),
            @Result(property = "travelName",column = "travel_name"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "startPlace", column = "start_place"),
            @Result(property = "travelDay", column = "travel_day"),
            @Result(property = "id", column = "id")
    })
    public List<TravelTotal> selectXingchengIdByFromUid(Integer fromUid, Integer toId, Integer type, Integer readType );

}
