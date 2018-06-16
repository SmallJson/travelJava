package com.bupt.travel.service;

import com.bupt.travel.dao.UserDao;
import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//和用户相关的服务
@Service
public class UserService extends BaseService{

    @Autowired
    UserDao userDao;

    public UserService(){
        urlMap.put("register", "https://a1.easemob.com/1148180614146538/travel/users");
        urlMap.put("login", "https://a1.easemob.com/1148180614146538/travel/users");
    }

    public User login(String account, String password){
        return userDao.login(account,password);
    }

    //数据库注册和环信注册需要保持一致
    //服务器的用户体系和环信的用户体系必须保持一致
    @Transactional
    public String register(UserBean userBean){
            boolean result =true;
            result = userDao.register(userBean);
           //注册到数据库成功后，将用户信息注册到环信中
            if(result ==true){
               String json = regiterIm(userBean);
            }
        return  result == true ?"注册成功":"该手机号码已经注册";
    }

    //目前使用环信开放授权注册，不需要利用token
    public String regiterIm(UserBean userBean){
        Map<String,Object> param = new HashMap<>();
        param.put("username", userBean.getPhone());
        param.put("password", userBean.getPassword());
        param.put("nickname", userBean.getName());
        int retry = 0;
        while (true){
            try {
                return restTemplateUtil.doPost(urlMap.get("register"), param,null);
            }catch (Exception e){
                if(retry == 2){
                    //两次注册失败
                    throw  e;
                }
                retry ++;
            }
        }
    }

    public UserInfo selectUserInfoByUid(Integer uid){
        return  userDao.selecyUserInfoByUid(uid);
    }
}
