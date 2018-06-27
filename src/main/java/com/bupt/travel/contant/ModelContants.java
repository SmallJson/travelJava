package com.bupt.travel.contant;

import java.util.HashMap;

public class ModelContants {
    //未正式提交的行程
    public static final int UN_COMMIT = 1;
    //正式提交，但是以完成的行程
    public static final int COMMIT_COMPLETETE =2;
    //正式提交，但是未完成的行程
    public static final int COMMIT_UNCOMPLETETE =3;

    /**
     * 人物关系设计
     */
    //我是儿子添加父亲
    public static final int child_father = 1;
    //女儿
    public static final int child_mother = 2;
    //我是父亲添加儿子
    public static final int father_child = 3;
    //我是母亲添加女儿
    public static final int mother_child = 4;

    public static  HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(1,"father");
        map.put(2,"mother");
        map.put(3, "child");
        map.put(4, "child");
    }
    public static String getRelationName(Integer type){
        return map.get(type);
    }

/* public static final String default_header ="http://10.108.245.188:8080/default_header.jpeg";
    public static final String HOST_URL = "http://10.108.245.188:8080/";*/
 public static final String HOST_URL = "http://123.206.50.85:8080/travel/";
   public static final String default_header ="http://123.206.50.85:8080/travel/default_header.jpeg";


    /**
     * 行程相关的常量信息
     */
    //行程完成
    public static final int COMPLETE = 1;
    //行程未完成
    public static final int UNCOMPLETE = 2;


    /**
     * 细节行程对应的类别
     */
    public static final int HOUSE = 1;
    public static final int TRAFFIC = 2;
    public static final int PLACE = 3;
    public static final int RES = 4;
}
