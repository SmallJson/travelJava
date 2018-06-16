package com.bupt.travel.dao;

import com.bupt.travel.contant.ModelContants;
import com.bupt.travel.mapper.UserInfoMapper;
import com.bupt.travel.mapper.UserMapper;
import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.model.requestBean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper infoMapper;
    public  User login(String account, String password){
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user =  userMapper.select(user);
        return user;
    }

    public boolean  register(UserBean userBean){
        //1.判断手机号是否注册
        Integer count = userMapper.selectIdByPhone(userBean.getPhone());
        if(count != null){
            return false;
        }

        //2.注册用户信息
        User user  = new User();
        user.setPassword(userBean.getPassword());
        user.setAccount(userBean.getPhone());
        userMapper.insert(user);

        //3.注册用户个人信息到数据库
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(user.getUid());
        userInfo.setName(userBean.getName());
        userInfo.setAvator(ModelContants.default_header);
        infoMapper.insertUserInfo(userInfo);

        return  true;
    }

    public UserInfo selecyUserInfoByUid(Integer uid){
        return infoMapper.selectUserInfoByUid(uid);
    }
}
