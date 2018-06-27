package com.bupt.travel.model.requestBean;

public class MessageBean {
    public Integer fromUid;
    public String dest;
    public Integer type;
    public String text;
    public Integer placeId;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
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
}
