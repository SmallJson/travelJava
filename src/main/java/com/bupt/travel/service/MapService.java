package com.bupt.travel.service;

import com.bupt.travel.model.Map.LocationBean;
import com.bupt.travel.model.Map.LocationInterface;
import com.bupt.travel.utils.RestTemplateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MapService  extends  BaseService{

    public MapService() {
        urlMap.put("selectLoacation","http://api.map.baidu.com/cloudgc/v1");
    }

    public List<LocationBean> selctLocation(String address,String ak, String output){
        Map<String, Object>  param = new HashMap<>();
        param.put("address", address);
        param.put("ak",ak);
        param.put("output",output);
        String json = restTemplateUtil.doGet(urlMap.get("selectLoacation"), param, null);
        return  filterLocation(LocationInterface.decode(json));
    }

    public List<LocationBean> filterLocation(List<LocationInterface.ResultBean> list){
        List<LocationBean> resultList = new ArrayList<LocationBean>();
        if(list == null){
            return resultList;
        }
        for(int i = 0 ;i < list.size(); i++){
            resultList.add(list.get(i).getLocation());
        }
        return  resultList;
    }

}
