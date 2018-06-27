package com.bupt.travel.controller;

import com.bupt.travel.model.Attraction.AttractionBean;
import com.bupt.travel.service.AttractionService;
import com.bupt.travel.utils.ResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 地点
 */
@Controller
public class AttractionControll {
    @Autowired
    AttractionService attractionService;

    @RequestMapping("attractionInfomation")
    @ResponseBody
    public Map<String, Object> getAttractionInfomation(@Param("keyword") String keyword){
        AttractionBean attractionBean =attractionService.selectAttraction(keyword);
        if(attractionBean == null){
            return ResponseUtil.error(null, "查询错误");
        }else{
            return  ResponseUtil.success(attractionBean,"查询成功");
        }
    }
}
