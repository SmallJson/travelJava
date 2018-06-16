package com.bupt.travel.dao;

import com.bupt.travel.contant.ModelContants;
import com.bupt.travel.mapper.UserMapper;
import com.bupt.travel.mapper.UserRelationMapper;
import com.bupt.travel.model.UserRelation;
import com.bupt.travel.model.reponseBean.RelationInfo;
import com.bupt.travel.model.requestBean.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//处理用户关系的内容
@Repository
public class UserRelationDao {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRelationMapper relationMapper;

    @Transactional
    public  String addRelation(Relation relation){
        //0.检测当前用户id是否存在
        Integer count = userMapper.selectUid(relation.uid);
        if(count < 1){
            return "当前用户不存在";
        }
        //1.添加对象账号名称，查找uid
        Integer destUid = userMapper.selectIdByPhone(relation.destPhone);
        if(null == destUid)
            return "目标用户不存在";
        //检查关系是否合理
        if(relation.getRelationType() > 4 || relation.getRelationType() < 1){
            return "关系不正确";
        }

        //2.检查是否已经存在关系
        UserRelation userRelation = new UserRelation();
        userRelation.setFromId(relation.uid);
        userRelation.setToId(destUid);
        userRelation.setRealtionType(relation.relationType);
        if(relationMapper.selectRelation(userRelation).equals(1)){
            return  "不能重复建立亲属关系";
        }

        //3.插入对象
        relationMapper.addRelation(userRelation);

        //4.反关系插入数据
        Integer reverseRelationType = 1;
        switch (relation.relationType){
            case ModelContants.child_father:
                reverseRelationType = ModelContants.father_child;
                break;
            case ModelContants.child_mother:
                reverseRelationType = ModelContants.mother_child;
                break;
            case ModelContants.mother_child:
                reverseRelationType = ModelContants.child_mother;
                break;
            case ModelContants.father_child:
                reverseRelationType = ModelContants.father_child;
                break;
        }
        userRelation.setFromId(destUid);
        userRelation.setToId(relation.uid);
        userRelation.setRealtionType(reverseRelationType);
        relationMapper.addRelation(userRelation);
        return "添加成功";
    }

    public  ArrayList<RelationInfo> selectRelationByUid(Integer uid){
        //0.判断Uid是否存在
        boolean exist = userMapper.selectUid(uid) >= 1 ? true : false;
        if(exist == false){
            return null;
        }
        //1.拿到亲友的uid信息
        List<UserRelation> list = relationMapper.selectRelationByUid(uid);

        ArrayList<RelationInfo> relationInfoList = new ArrayList<>();
        //2.拿到亲友的uid之后，查询好友信息(手机号码+用户信息)
        for(UserRelation userRelation :list){
            RelationInfo relationInfo = userMapper.selectUserInfoByUid(userRelation.getToId());
            relationInfo.setRelationType(userRelation.getRealtionType());
            relationInfoList.add(relationInfo);
          /*  relationMap.put(ModelContants.getRelationName(userRelation.getRealtionType())
                    , new ArrayList<RelationInfo>());
            relationMap.get(ModelContants.getRelationName(userRelation.getRealtionType())).add(relationInfo);*/
        }
        //3.返回亲友信息
        return relationInfoList;
    }

}
