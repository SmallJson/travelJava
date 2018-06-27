package com.bupt.travel.mapper;

import com.bupt.travel.model.Place;
import com.bupt.travel.model.requestBean.PlaceBean;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlaceMapper {

    @Insert("insert into place(id,place_name,play_time,complete,img) values(#{id}," +
            "#{placeName},#{playTime},#{complete},#{img}) on duplicate key update place_name = #{placeName}," +
            "play_time=#{playTime}")
    public  int  insertPlace(Place place);

    @Select("select id,place_name,play_time, complete,img from place where id =#{id}")
    @Results({
            @Result(property = "placeName" ,column = "place_name")
            ,@Result(property = "playTime",column = "play_time")
            ,@Result(property = "id",column = "id")
            ,@Result(property = "imageUrl", column = "id", many = @Many(select = "com.bupt.travel.mapper.MessageMapper.selectImageUrlByPlaceId"))
    })
    public PlaceBean selectPlace(Integer id);


    @Insert("update place set complete = #{complete} where id = #{id}")
    public int updateComplete(@Param("id") Integer id, @Param("complete") Integer complete);
}
