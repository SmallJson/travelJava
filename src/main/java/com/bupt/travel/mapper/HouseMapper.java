package com.bupt.travel.mapper;

import com.bupt.travel.model.House;
import com.bupt.travel.model.requestBean.HouseBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HouseMapper {
    //不存在则插入，否则更新数据
    @Insert("insert into house(id,house_name,house_address) values(" +
            "#{id},#{houseName},#{houseAddress}) on duplicate key update house_name=" +
            "#{houseName},house_address=#{houseAddress}")
    public void insertHouse(House house);


    @Select("select house_name, house_address from house where id= #{id}")
    @Results({
            @Result(property = "houseName",column = "house_name"),
            @Result(property = "houseAddress",column = "house_address")
    })
    public HouseBean selectHouse(Integer id);


}
