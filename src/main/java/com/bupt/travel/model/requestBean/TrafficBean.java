package com.bupt.travel.model.requestBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29 0029.
 * 交通信息的实体bean
 */

public class TrafficBean {
    //航班的名称
    public String flightName;
    //出发时间
    public String startTime;
    //出发地点
    public String startPlace;
    //目的地点
    public String endPlace;

    Integer id;
    Integer complete;

    public String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
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

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    @Override
    public String toString() {
        return "TrafficBean{" +
                "flightName='" + flightName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                '}';
    }
}
