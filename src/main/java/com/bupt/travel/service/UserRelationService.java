package com.bupt.travel.service;

import com.bupt.travel.dao.UserRelationDao;
import com.bupt.travel.model.reponseBean.RelationInfo;
import com.bupt.travel.model.requestBean.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Map;

@Service
public class UserRelationService extends BaseService{

    @Autowired
    UserRelationDao userRelationDao;

    //添加亲属关系
    public  String   addRelation(Relation relation){
       String msg ="";
       try {
           msg = userRelationDao.addRelation(relation);
       }catch (Exception e){
           e.printStackTrace();
           msg = "后台录入操作失败";
       }
       return msg;
    }

    //查询亲属关系
    public ArrayList<RelationInfo> selectRelation(Integer uid){
       return userRelationDao.selectRelationByUid(uid);
    }
}
