package com.bupt.travel.model.requestBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 酒店信息
 */
public class HouseBean {
    String houseName;
    String houseAddress;
    Integer complete;
    Integer id;

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

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    @Override
    public String toString() {
        return "HouseBean{" +
                "houseName='" + houseName + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                '}';
    }
}
