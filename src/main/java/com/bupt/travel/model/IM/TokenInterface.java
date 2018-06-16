package com.bupt.travel.model.IM;

import com.bupt.travel.utils.JacksonUtil;
import org.springframework.util.StringUtils;

//获取环信Token的
public class TokenInterface {
    public String access_token ;
    public String expires_in;
    public String application;
    //解析json数据，提取token
    public  static  String decode(String json){
        if(StringUtils.isEmpty(json)){
            return  "";
        }
        TokenInterface tokenInterface = JacksonUtil.readValue(json, TokenInterface.class);
        if(tokenInterface != null){
            return tokenInterface.access_token;
        }else{
            return  "";
        }
    }
}
