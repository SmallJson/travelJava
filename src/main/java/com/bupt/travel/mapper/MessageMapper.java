package com.bupt.travel.mapper;

import com.bupt.travel.model.Message;
import com.bupt.travel.model.MsgUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {

    @Insert("insert into message(from_uid,to_uid,creat_time,type,text,img_url) " +
            "values(#{fromUid},#{toUid},#{creat_time},#{type},#{text},#{imgUrl})")
    public int insertMsg(Message msg);

    @Select("select * from message where from_uid =#{fromUid} and to_uid=#{toUid}")
    public Message selecyMsg(MsgUser msgUser);
}
