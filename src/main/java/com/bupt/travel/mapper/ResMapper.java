package com.bupt.travel.mapper;

import com.bupt.travel.model.Res;
import com.bupt.travel.model.requestBean.ResBean;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ResMapper {

    @Insert("insert into res(id,res_name,res_address,complete,img) values(#{id},#{resName},#{resAddress},#{complete},#{img}) " +
            "on duplicate key update res_name =#{resName}, res_address=#{resAddress}")
    public void insertRes(Res res);

    @Select("select * from  res where id = #{id}")
    @Results({
            @Result(property = "resName",column = "res_name")
            ,@Result(property = "resAddress",column = "res_address")
    })
    public ResBean selectRes(Integer id);

    @Insert("update res set complete = #{complete} where id = #{id}")
    public int updateComplete(@Param("id") Integer id, @Param("complete") Integer complete);
}
