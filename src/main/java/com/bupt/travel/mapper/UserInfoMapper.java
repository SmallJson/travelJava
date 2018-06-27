package com.bupt.travel.mapper;

import com.bupt.travel.model.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Insert("insert into user_info(id,avator,name) values(#{uid},#{avator},#{name})")
    public int insertUserInfo(UserInfo userInfo);

    @Select("select * from user_info where id = #{uid}")
    @Results({
            @Result(property = "uid",column = "id")
    })
    public UserInfo selectUserInfoByUid(Integer uid);

    @Update("update  user_info  set avator  = #{avator} where id =#{uid}")
    public int updateInfo(UserInfo info);

}
