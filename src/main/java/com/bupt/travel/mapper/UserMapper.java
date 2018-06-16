package com.bupt.travel.mapper;

import com.bupt.travel.model.User;
import com.bupt.travel.model.reponseBean.RelationInfo;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserMapper {

    @Insert("insert into user(account,password) values(#{account},#{password})")
    @Options(useGeneratedKeys = true, keyProperty ="uid" )
    public void insert(User user);

    @Select("select * from user where account = #{account} and password =#{password}")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "info",column = "uid",one = @One(select = "com.bupt.travel.mapper.UserInfoMapper.selectUserInfoByUid") )
    })
    public User select(User user);

    @Select("select uid from user where account = #{phone}")
    public Integer selectIdByPhone(String phone);

    @Select("select count(uid) from user where uid = #{uid}")
    public Integer selectUid(Integer uid);

    @Select("select u.account as phone,ui.name as name, ui.avator as avator " +
            " from user u inner join user_info ui on u.uid = ui.id " +
            " where u.uid =#{uid}" )
    public RelationInfo selectUserInfoByUid(Integer uid);

}
