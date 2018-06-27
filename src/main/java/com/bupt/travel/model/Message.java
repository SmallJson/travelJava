package com.bupt.travel.model;

public class Message {

    public  Integer id;
    public  Integer fromUid;
    public  Integer toUid;
    public String creatTime;
    public Integer type;
    public String text;
    public String imgUrl;
    public Integer travelId;
    public String fromAvator;
    public String fromName;
    public Integer readType;

    /**
     * 如果Message是图片信息，该字段代表是哪个景点信息的图片
     */
    public Integer placeId;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getReadType() {
        return readType;
    }

    public void setReadType(Integer readType) {
        this.readType = readType;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public UserInfo fromUser;

    public UserInfo getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserInfo fromUser) {
        this.fromUser = fromUser;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public String getFromAvator() {
        return fromAvator;
    }

    public void setFromAvator(String fromAvator) {
        this.fromAvator = fromAvator;
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

    public void setFromUid(Integer fromUuid) {
        this.fromUid = fromUuid;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
