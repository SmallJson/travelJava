package com.bupt.travel.service;

import com.bupt.travel.contant.AttractionContans;
import com.bupt.travel.model.Attraction.AttractionBean;
import com.bupt.travel.model.Attraction.AttractionInterface;
import com.bupt.travel.model.Attraction.PageBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttractionService extends BaseService{

    public AttractionService() {
        urlMap.put("attraction", "http://route.showapi.com/268-1");
    }


    public AttractionBean selectAttraction(String keyword){
        Map<String, Object> param = new HashMap<>();
        param.put("keyword", keyword);
        param.put("showapi_sign", AttractionContans.showapi_sign);
        param.put("showapi_appid", AttractionContans.showapi_appid);
        String json = restTemplateUtil.doGet(urlMap.get("attraction"), param, null);
        AttractionBean attractionBean = filterAttraction(AttractionInterface.decode(json));
        return  attractionBean;
    }


    public AttractionBean filterAttraction(AttractionInterface.ShowapiResBodyBean showapiResBodyBean){
        if(showapiResBodyBean != null){
            PageBean pageBean = showapiResBodyBean.getPagebean();
            if(pageBean != null){
                List<AttractionBean> attractionBeanList = pageBean.getContentlist();
                if(attractionBeanList != null && attractionBeanList.size()!=0){
                    return  attractionBeanList.get(0);
                }
            }
        }
        return  null;
    }
}
