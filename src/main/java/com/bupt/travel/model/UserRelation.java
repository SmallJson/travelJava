package com.bupt.travel.model;

public class UserRelation {
    //唯一主键
    Integer id;
    /**
     * fromID的好友是toID，他们之间的关系是realationType
     */
    Integer fromId;

    Integer toId;

    Integer realtionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getRealtionType() {
        return realtionType;
    }

    public void setRealtionType(Integer realtionType) {
        this.realtionType = realtionType;
    }

    @Override
    public String toString() {
        return "UserRelation{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", realtionType=" + realtionType +
                '}';
    }
}
