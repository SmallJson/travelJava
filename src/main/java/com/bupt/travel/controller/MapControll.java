package com.bupt.travel.controller;

import com.bupt.travel.model.Map.LocationBean;
import com.bupt.travel.service.MapService;
import com.bupt.travel.utils.ResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 百度地图相关
 */
@Controller
public class MapControll {
    @Autowired
    MapService mapService;

    @RequestMapping("cloudgc/v1")
    @ResponseBody
    public Map<String, Object> selectAddress(@Param("address") String address
                                            , @Param("ak")String ak
                                            , @Param("output")String output){
        List<LocationBean> list = mapService.selctLocation(address, ak, output);
        if(list == null){
           return ResponseUtil.error(null,"查找失败");
        }else{
           return ResponseUtil.success(list,"查找成功");
        }
    }

}
