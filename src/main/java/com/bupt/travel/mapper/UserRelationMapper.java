package com.bupt.travel.mapper;

import com.bupt.travel.model.UserRelation;
import org.apache.ibatis.annotations.*;

import java.util.List;

//用户关系信息表
@Mapper
public interface UserRelationMapper {
    @Insert("insert into user_relation(from_uid,to_uid,realtion_type) values(#{fromId},#{toId},#{realtionType})")
    public boolean addRelation(UserRelation userRelation);

    @Select("select to_uid,realtion_type from user_relation where from_uid =#{uid}")
    @Results({
         @Result(property = "toId", column = "to_uid")
         , @Result(property = "realtionType", column = "realtion_type")
    })
    public List<UserRelation> selectRelationByUid(Integer uid);

    @Select("select count(id) from user_relation where from_uid = #{fromId} and to_uid = #{toId}")
    public Integer selectRelation(UserRelation relation);
}
