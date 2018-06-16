package com.bupt.travel.model;

import org.apache.ibatis.annotations.Insert;

public class TravelTotal {
    //行程唯一id
    public Integer id;
    //规划人
    public Integer fromUid;
    //被规划人
    public Integer toUid;
    //是否已读标识
    public Integer readType;
    //行程创建时间
    public String creatTime;
    //行程类型
    public Integer type;
    public String travelName;
    public  String startTime;
    public  String startPlace;
    public Integer travelDay;

    public Integer getReadType() {
        return readType;
    }

    public void setReadType(Integer readType) {
        this.readType = readType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }



    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public Integer getTravelDay() {
        return travelDay;
    }

    public void setTravelDay(Integer travelDay) {
        this.travelDay = travelDay;
    }
}
