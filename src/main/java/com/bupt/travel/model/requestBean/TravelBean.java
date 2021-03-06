package com.bupt.travel.model.requestBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/28 0028.
 * 行程信息实体bean
 */
public class TravelBean {
    //旅行名称
    public String travelName;
    //目标城市
    public String city;
    //持续时间
    public Integer dataCount;
    //出发日期
    public String time;


    //查询行程信息独有的信息
    //该行程的创建时间
    public String creatTime;

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "TravelBean{" +
                "travelName='" + travelName + '\'' +
                ", city='" + city + '\'' +
                ", dataCount=" + dataCount +
                ", time='" + time + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }
}
