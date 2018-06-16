package com.bupt.travel.mapper;

import com.bupt.travel.model.Res;
import com.bupt.travel.model.requestBean.ResBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ResMapper {

    @Insert("insert into res(id,res_name,res_address) values(#{id},#{resName},#{resAddress}) " +
            "on duplicate key update res_name =#{resName}, res_address=#{resAddress}")
    public void insertRes(Res res);

    @Select("select res_name, res_address from  res where id = #{id}")
    @Results({
            @Result(property = "resName",column = "res_name")
            ,@Result(property = "resAddress",column = "res_address")
    })
    public ResBean selectRes(Integer id);
}
