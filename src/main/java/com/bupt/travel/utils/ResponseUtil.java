package com.bupt.travel.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static final Integer success_code =200;
    public static final Integer error_code = -1;
    public static final String success_msg = "接口正常";
    public static final String error_msg = "接口异常";


    //生成成功数据的接口信息
    public  static Map<String, Object> success(Object data){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", success_msg);
        map.put("code",success_code);
        map.put("data",data);
        return map;
    }

    //生成成功数据的接口信息
    public  static Map<String, Object> success(Object data, String msg){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code",success_code);
        map.put("data",data);
        return map;
    }

    //失败数据的接口信息
    public static Map<String, Object> error(Object data){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", error_msg);
        map.put("code",error_code);
        map.put("data",data);
        return map;
    }

    //带有提示失败数据接口信息
    public static Map<String, Object> error(Object data,String reason){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", reason);
        map.put("code",error_code);
        map.put("data",data);
        return map;
    }

    public static Map<String, Object> nomal(String msg){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        return map;
    }
}
