package com.bupt.travel.mapper;

import com.bupt.travel.model.Place;
import com.bupt.travel.model.requestBean.PlaceBean;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlaceMapper {

    @Insert("insert into place(id,place_name,play_time) values(#{id}," +
            "#{placeName},#{playTime}) on duplicate key update place_name = #{placeName}," +
            "play_time=#{playTime}")
    public  int  insertPlace(Place place);

    @Select("select place_name,play_time from place where id =#{id}")
    @Results({
            @Result(property = "placeName" ,column = "place_name")
            ,@Result(property = "playTime",column = "play_time")
    })
    public PlaceBean selectPlace(Integer id);
}
