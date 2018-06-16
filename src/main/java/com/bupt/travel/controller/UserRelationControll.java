package com.bupt.travel.controller;

import com.bupt.travel.dao.UserRelationDao;
import com.bupt.travel.model.reponseBean.RelationInfo;
import com.bupt.travel.model.requestBean.Relation;
import com.bupt.travel.service.UserRelationService;
import com.bupt.travel.utils.ResponseUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class UserRelationControll {

    @Autowired
    UserRelationService userRelationService;

    @RequestMapping(value = "addRelation", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addRelation(@RequestParam(required = true) Integer uid
                                            , @RequestParam(required = true) String destPhone
                                            , @RequestParam(required = true) Integer relationType){
        Relation relation = new Relation();
        relation.setUid(uid);
        relation.setDestPhone(destPhone);
        relation.setRelationType(relationType);
        String msg = userRelationService.addRelation(relation);
        return ResponseUtil.nomal(msg);
    }

    @RequestMapping(value = "selectRelation" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectRelation( @RequestParam(required = true) Integer uid){
         ArrayList<RelationInfo> data = userRelationService.selectRelation(uid);
        if(data == null){
            return  ResponseUtil.error(null, "用户不存在");
        }else{
            return ResponseUtil.success(data);
        }
    }

}
