package com.bupt.travel.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.core.annotation.Order;

import java.util.Map;

public class TravelSqlProvider {

    //查询规划行程sql
    public String selectTravelByFromUid(Integer fromUid, Integer toId, Integer type
                                        ,Integer readType){
        System.out.println(""+fromUid + type +readType);
        return new SQL(){
            {
                SELECT("*");
                FROM("travel_total");
                if(fromUid != null){
                    WHERE("from_uid=" +fromUid);
                }
                if(toId != null){
                    WHERE("to_uid=" +toId);
                }
                if(type != null){
                    WHERE("type=" +type);
                }
                if(readType !=null){
                    WHERE("read_type="+readType);
                }
                ORDER_BY("creat_time DESC ");
            }
        }.toString();
    }
}
