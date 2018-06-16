package com.bupt.travel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String UnixToDate(String unix){
        Long timestamp = Long.parseLong(unix);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        return date;
    }
}