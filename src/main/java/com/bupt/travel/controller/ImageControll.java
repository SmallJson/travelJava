package com.bupt.travel.controller;

import com.bupt.travel.utils.FileUtil;
import com.bupt.travel.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ImageControll {

    @RequestMapping(value = "image",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object>  uploadImage(@RequestParam(value="image",required=false) MultipartFile file
            , HttpServletRequest request){
        String url = FileUtil.processImage(file, request);
        if(StringUtils.isEmpty(url)){
            return ResponseUtil.error(null, "上传失败");
        }else{
            return  ResponseUtil.success(url, "上传成功");
        }
    }
}
