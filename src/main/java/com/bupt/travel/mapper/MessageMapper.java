package com.bupt.travel.mapper;

import com.bupt.travel.model.Message;
import com.bupt.travel.model.MsgUser;
import com.bupt.travel.model.reponseBean.PhotoInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Insert("insert into message(from_uid,to_uid,creat_time,type,text,img_url,travel_id,from_avator,from_name,read_type,place_id) " +
            "values(#{fromUid},#{toUid},#{creatTime},#{type},#{text},#{imgUrl},#{travelId},#{fromAvator},#{fromName},#{readType},#{placeId})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int insertMsg(Message msg);

    @Select("select * from message where to_uid=#{toUid} order by creat_time DESC")
    @Results({
            @Result(property = "fromUid",column = "from_uid")
            ,@Result(property = "toUid",column="to_uid")
            ,@Result(property = "creatTime",column = "creat_time")
            ,@Result(property = "type", column = "type")
            ,@Result(property = "text",column = "text")
            ,@Result(property = "imgUrl",column = "img_url")
            ,@Result(property = "travelId",column = "travel_id")
            ,@Result(property = "fromAvator",column = "from_avator")
            ,@Result(property = "fromName",column = "from_name")
            ,@Result(property = "readType", column = "read_type")
            ,@Result(property = "fromUser",column = "from_uid", one=@One(select = "com.bupt.travel.mapper.UserInfoMapper.selectUserInfoByUid"))
    })
    public List<Message> selectMsg(MsgUser msgUser);


    /**
     * 更新message的已读状态
     * @param read
     * @param id
     */
    @Update("update message set read_type = #{read} where id = #{id}")
    public Integer updateMsgRead(@Param("read") Integer read, @Param("id") Integer id);

    /**
     * 获取指定id，指定状态的消息数
     * @param read
     * @param toUid
     */
    @Select("select  ifnull(count(read_type),0) from message where read_type = #{read} and to_uid = #{toUid}")
    public Integer selectUnReadMeg(@Param("read") Integer read, @Param("toUid") Integer toUid);

    /**
     * 通过placeId查询该景点下，关联的所有图片
     */
    @Select("select img_url from message where place_id = #{placeId} and type=1")
    public List<String> selectImageUrlByPlaceId(@Param("placeId") Integer placeId);


    @Select("select min(creat_time) as creatTime,place_id as placeId from message where " +
            "from_uid=#{fromId} and place_id is not null and type =#{type} group by place_id order by creatTime")
    public List<Message> selectPhoto(@Param("fromId") Integer uid
                                      , @Param("type") Integer type);
    /*存在优化的可能
    * 通过meessageId来删除信息
    * */
    @Delete("delete from message where img_url = #{imgUrl}and place_id=#{placeId}")
    public int updatePlacePhoto(@Param("imgUrl")String imgUrl, @Param("placeId") Integer placeId);
}
