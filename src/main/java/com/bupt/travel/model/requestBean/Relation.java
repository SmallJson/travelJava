package com.bupt.travel.model.requestBean;

public class Relation {
    //账号的uid信息
    public Integer uid;
    //添加对象的账号名称
    public  String destPhone;
    //你选择添加的关系
    public Integer relationType;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDestPhone() {
        return destPhone;
    }

    public void setDestPhone(String destPhone) {
        this.destPhone = destPhone;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }
}
