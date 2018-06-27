package com.bupt.travel.controller;

import com.bupt.travel.model.reponseBean.PhotoInfo;
import com.bupt.travel.service.PhotoService;
import com.bupt.travel.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PhotoControll {

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "photo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectPhone(@RequestParam(required = true) Integer fromUid){
        List<PhotoInfo> list = photoService.selectPhone(fromUid);
        if(list == null){
            return ResponseUtil.error(null,"查询失败");
        }else{
            return ResponseUtil.success(list,"查询成功");
        }
    }
}
