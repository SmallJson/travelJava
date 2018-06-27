package com.bupt.travel.model;

public class Res {

    public Integer id;

    //餐饮名称
    public String resName;

    //餐饮地址
    public String resAddress;

    Integer complete;

    public String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }
}
