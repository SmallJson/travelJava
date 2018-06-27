package com.bupt.travel.model.reponseBean;

import com.bupt.travel.model.UserInfo;

//用户登录返回的Bean
public class LoginInterface {
    Integer uid;
    String account;
    String password;
    String roleType;
    Integer unReadMsg;
    UserInfo info;

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getUnReadMsg() {
        return unReadMsg;
    }

    public void setUnReadMsg(Integer unReadMsg) {
        this.unReadMsg = unReadMsg;
    }
}
