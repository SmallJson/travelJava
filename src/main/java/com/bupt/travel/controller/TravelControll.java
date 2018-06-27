package com.bupt.travel.controller;

import com.bupt.travel.model.Res;
import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.TravelTotalBean;
import com.bupt.travel.service.ImService;
import com.bupt.travel.service.TravelService;
import com.bupt.travel.service.UserService;
import com.bupt.travel.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Controller
public class TravelControll {
    @Autowired
    TravelService travelService;
    @Autowired
    ImService imService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "addTravel",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertTravel(@RequestBody(required = true) TravelTotalBean travelTotalBean){

        if(travelTotalBean.getFromUid() == null && travelTotalBean.getPhone() == null){
            return ResponseUtil.error(null,"fromUid，Phone不能为空");
        }

        boolean result = travelService.insertTravel(travelTotalBean);
        if(result == false){
            return ResponseUtil.error(null,"分享失败");
        }
        return ResponseUtil.success("分享成功");
    }

    //通过travelId查找旅游信息
    @RequestMapping(value = "selectTravelByid",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectTravelById(@RequestParam(required =true) Integer travelId){
        TravelTotalBean travelTotalBean = travelService.selectTravelById(travelId);
        return  ResponseUtil.success(travelTotalBean);
    }

    @RequestMapping(value = "selectTravel",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Object> selectTravel( @RequestParam(name = "fromUid",required = false) Integer fromUid
                                             ,@RequestParam(name = "toUid",required = false) Integer toUid
                                             ,@RequestParam(name = "type",required = false) Integer type
                                             ,@RequestParam(name = "readType",required = false) Integer readType){

        if(fromUid == null && toUid == null){
            return ResponseUtil.error(null,"fromUid，toUid至少存在一个");
        }

        List<TravelTotalBean> list = travelService.selectTravel(fromUid, toUid, type ,readType);
        return ResponseUtil.success(list);
    }


    @RequestMapping(value = "updateTravel",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateTravel(@RequestBody TravelTotalBean travelTotalBean){
        //1.检查信息，xingchengId信息
        if(travelTotalBean.getXingchengId() == null){
            return ResponseUtil.error(null,"xingchengId不能为null");
        }

        boolean result = travelService.updateTravel(travelTotalBean);

        if(result == false){
            return ResponseUtil.error(null,"更新失败");
        }
        return ResponseUtil.success(null,"更新成功");
    }

    @RequestMapping(value ="updateTravelComplete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateTravelDetailDay(@RequestParam(required = true) Integer id
                                                    ,@RequestParam(required = true) Integer type){

        int result = travelService.updataComplete(id,type);
        if(result < 1){
            return ResponseUtil.error(null,"更新旅行细节状态错误");
        }else{
            return ResponseUtil.success(null,"更新旅行细节状态成功");
        }
    }
}
