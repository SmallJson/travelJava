package com.bupt.travel.service;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.contant.ModelContants;
import com.bupt.travel.model.IM.TextMessage;
import com.bupt.travel.model.IM.TokenInterface;
import com.bupt.travel.utils.ResponseUtil;
import com.bupt.travel.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//Service共同的基础类
public class BaseService {

    @Autowired
    public  RestTemplateUtil restTemplateUtil;

    public Map<String, String> urlMap = new HashMap<>();

    public BaseService(){
        urlMap.put("token", "https://a1.easemob.com/1148180614146538/travel/token");
    }
}
