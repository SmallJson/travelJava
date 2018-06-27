package com.bupt.travel.service;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.dao.MessageDao;
import com.bupt.travel.dao.UserDao;
import com.bupt.travel.mapper.PlaceMapper;
import com.bupt.travel.model.Message;
import com.bupt.travel.model.Place;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.reponseBean.PhotoInfo;
import com.bupt.travel.model.requestBean.PlaceBean;
import com.bupt.travel.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {
    @Autowired
    UserDao userDao;
    @Autowired
    PlaceMapper placeMapper;
    @Autowired
    MessageDao messageDao;

    /**
     * 查询发出去的的所有图片消息
     */
    public List<PhotoInfo> selectPhone(Integer fromUid){
        List<PhotoInfo> photoInfoList = new ArrayList<>();
        //1.查询个人信息
        UserInfo info  = userDao.selecyUserInfoByUid(fromUid);
        //2.查询所有地点信息
        List<Message> messageList = messageDao.selectPhoto(fromUid, IMContants.IMAGE_MSG);
        for(int i = 0 ;i<messageList.size() ;i++){
            Message message = messageList.get(i);
            PhotoInfo photoInfo = new PhotoInfo();
            photoInfo.setUserInfo(info);
            photoInfo.setTime(TimeUtil.UnixToDate(message.getCreatTime()));
            photoInfo.setPlace(placeMapper.selectPlace(message.getPlaceId()));
            photoInfoList.add(photoInfo);
        }
        return photoInfoList;
    }
}
