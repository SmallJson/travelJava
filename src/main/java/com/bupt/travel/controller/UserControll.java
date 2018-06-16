package com.bupt.travel.controller;


import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.UserBean;
import com.bupt.travel.service.UserService;
import com.bupt.travel.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户相关的操作，
 * 比如，登录，注册等内容
 */
@Controller
public class UserControll {
    @Autowired
    UserService userService;

    @RequestMapping(value = "account/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required = true) String account
                                    , @RequestParam(required = true)String password){
        User user = userService.login(account,password);
      if(user != null){
          return  ResponseUtil.success(user);
      }else{
          return ResponseUtil.error(null,"账号密码错误");
      }
    }


    @RequestMapping(value = "account/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestBody UserBean user){

        if(StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.password)
                ||StringUtils.isEmpty(user.name)){
            return ResponseUtil.nomal("注册信息不能为空");
        }
        String msg = userService.register(user);
        return ResponseUtil.nomal(msg);
    }

}
