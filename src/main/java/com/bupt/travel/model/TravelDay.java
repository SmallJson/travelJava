package com.bupt.travel.model;

public class TravelDay {
    //唯一主键
    Integer id;
    //天数
    Integer day;
    //指定行程id
    Integer xingchengId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getXingchengId() {
        return xingchengId;
    }

    public void setXingchengId(Integer xingchengId) {
        this.xingchengId = xingchengId;
    }
}
