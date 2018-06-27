package com.bupt.travel.model.reponseBean;

import com.bupt.travel.model.Place;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.PlaceBean;
import org.springframework.util.StringUtils;

import java.util.List;

//封装相册信息的类
public class PhotoInfo {

    public UserInfo userInfo;

    public String time;


    public PlaceBean place;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


   public PlaceBean getPlace() {
        return place;
    }

    public void setPlace(PlaceBean place) {
        this.place = place;
    }
}
