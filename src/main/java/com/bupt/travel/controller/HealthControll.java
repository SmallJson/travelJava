package com.bupt.travel.controller;

import com.bupt.travel.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HealthControll {

    @RequestMapping("/health")
    @ResponseBody
    public Map<String, Object> Health(){
        return ResponseUtil.success("health");
    }
}
