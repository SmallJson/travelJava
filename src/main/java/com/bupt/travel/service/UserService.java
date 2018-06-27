package com.bupt.travel.service;

import com.bupt.travel.dao.UserDao;
import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//和用户相关的服务
@Service
public class UserService extends BaseService{

    @Autowired
    UserDao userDao;

    public UserService(){
        urlMap.put("register", "http://a1.easemob.com/1148180614146538/travel/users");
        urlMap.put("login", "http://a1.easemob.com/1148180614146538/travel/users");
    }

    public User login(String account, String password){
        return userDao.login(account,password);
    }

    //数据库注册和环信注册需要保持一致
    //服务器的用户体系和环信的用户体系必须保持一致
    @Transactional
    public boolean register(UserBean userBean){
            boolean result =true;
            String json = regiterIm(userBean);
            System.out.println(json);
            result = userDao.register(userBean);
        return  result;
    }

    //目前使用环信开放授权注册，不需要利用token
    public String regiterIm(UserBean userBean){
        int retry = 0;
        Map<String,Object> param = new HashMap<>();
        param.put("username", userBean.getPhone());
        param.put("password", userBean.getPassword());
        param.put("nickname", userBean.getName());
        return restTemplateUtil.doPost(urlMap.get("register"), param,null);
    }

    public UserInfo selectUserInfoByUid(Integer uid){
        return  userDao.selecyUserInfoByUid(uid);
    }

    public int updateUserInfo(Integer uid, String avator){
        UserInfo info = new UserInfo();
        info.setAvator(avator);
        info.setUid(uid);
       return userDao.updateUserInfo(info);
    }
}
