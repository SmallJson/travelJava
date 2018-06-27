package com.bupt.travel.model.requestBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 饭店信息的实体内容
 */
public class ResBean {
    public String  resName;
    public String  resAddress;

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

    @Override
    public String toString() {
        return "ResBean{" +
                "resName='" + resName + '\'' +
                ", resAddress='" + resAddress + '\'' +
                '}';
    }
}
