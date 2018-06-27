package com.bupt.travel.controller;


import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.reponseBean.LoginInterface;
import com.bupt.travel.model.requestBean.UserBean;
import com.bupt.travel.service.ImService;
import com.bupt.travel.service.UserService;
import com.bupt.travel.utils.ResponseUtil;
import com.sun.net.httpserver.Authenticator;
import org.apache.ibatis.annotations.Result;
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
    @Autowired
    ImService imService;

    @RequestMapping(value = "account/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required = true) String account
                                    , @RequestParam(required = true)String password){
      User user = userService.login(account,password);
      if(user != null){
          //后期可以优化，放在一条sql语句里面执行
          Integer unReadMsg = imService.selectUnReadMsg(user.getUid());
          LoginInterface loginInterface = new LoginInterface();
          loginInterface.setAccount(user.getAccount());
          loginInterface.setPassword(user.getPassword());
          loginInterface.setRoleType(user.getRoleType());
          loginInterface.setUid(user.getUid());
          loginInterface.setUnReadMsg(unReadMsg);
          UserInfo info = userService.selectUserInfoByUid(user.getUid());
          loginInterface.setInfo(info);
          return  ResponseUtil.success(loginInterface);
      }else{
          return ResponseUtil.error(null,"账号密码错误");
      }
    }


    @RequestMapping(value = "account/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestBody UserBean user){

        if(StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.password)
                ||StringUtils.isEmpty(user.name)){
            return ResponseUtil.error(null,"注册信息不能为空");
        }
        boolean result = userService.register(user);
        if(result){
            return ResponseUtil.success(null,"注册成功");
        }else {
            return  ResponseUtil.error(null,"该账号已被注册");
        }
    }

    @RequestMapping(value = "avator",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updataUserInfo(@RequestParam("uid") Integer uid, @RequestParam("avator") String avator){
        int count = userService.updateUserInfo(uid, avator);
        if(count < 1){
            return ResponseUtil.error(null,"更新失败");
        }else{
            return ResponseUtil.success(null,"更新成功");
        }
    }

}
