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

    /*    //发送一条消息给分享对象
        //1.通过id查询分享人姓名
        UserInfo userInfo = userService.selectUserInfoByUid(travelTotalBean.fromUid);
        //3.拼接分享消息
        String msg = userInfo.getName()+"指定了一条新行程";
        imService.sendTextMessage(userInfo.getName(), travelTotalBean.getPhone(), msg);
        System.out.println("已经分享一条消息");*/
        return ResponseUtil.success("分享成功");
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

}
