package com.bupt.travel.mapper;

import com.bupt.travel.model.UserRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRelationMapperTest {
    @Autowired
    UserRelationMapper relationMapper;

    @Test
    public void addRelation() {
        UserRelation relation = new UserRelation();
        relation.setFromId(3);
        relation.setToId(7);;
        relation.setRealtionType(2);
        relationMapper.addRelation(relation);
    }

    @Test
    public void selectRelation(){
        List<UserRelation> list = relationMapper.selectRelationByUid(3);
        for(UserRelation relation :list){
            System.out.println(relation);
        }
    }
}