package com.bupt.travel.dao;

import com.bupt.travel.model.requestBean.Relation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRelationDaoTest {
    @Autowired
    UserRelationDao userRelationDao;

    //添加好友关系
    @Test
    public void addRelation() {
        Relation relation = new Relation();
        relation.setUid(3);
        relation.setDestPhone("184351345799");
        relation.setRelationType(2);
        System.out.println(userRelationDao.addRelation(relation));
    }

    //查询当前用户的好友关系
    @Test
    public void getRelation(){
        System.out.println(userRelationDao.selectRelationByUid(3));
    }
}