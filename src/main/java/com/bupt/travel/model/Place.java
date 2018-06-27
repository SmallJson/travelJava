package com.bupt.travel.model;

public class Place {
    Integer id;

    String placeName;

    String playTime;

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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
}
