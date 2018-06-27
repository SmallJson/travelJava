package com.bupt.travel.dao;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.mapper.MessageMapper;
import com.bupt.travel.mapper.UserInfoMapper;
import com.bupt.travel.model.Message;
import com.bupt.travel.model.MsgUser;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.MessageBean;
import com.bupt.travel.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    @Autowired
    MessageMapper  messageMapper;

    @Autowired
    UserInfoMapper infoMapper;

    public void insertMesssage(Message message){
            messageMapper.insertMsg(message);
    }

    public List<Message> selectMessage(Integer toUid){
        MsgUser user = new MsgUser();
        user.setToUid(toUid);
        List<Message> list = messageMapper.selectMsg(user);
        for(int i = 0 ;i < list.size();i++){
            list.get(i).setCreatTime(TimeUtil.UnixToDate(list.get(i).getCreatTime()+""));
        }
        return list;
    }

    //修改消息状态
    public int updateMessageRead(Integer read,Integer id){
        return messageMapper.updateMsgRead(read, id);
    }

    //查询未读消息数量
    public int selectUnReadMessage(Integer read ,Integer toUid){
        return  messageMapper.selectUnReadMeg(read,toUid);
    }

    //查找所有照片地点信息
    public  List<Message> selectPhoto(Integer fromUid, Integer type){
        return  messageMapper.selectPhoto(fromUid, type);
    }
}
