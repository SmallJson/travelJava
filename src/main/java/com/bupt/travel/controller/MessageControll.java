package com.bupt.travel.controller;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.model.requestBean.MessageBean;
import com.bupt.travel.service.ImService;
import com.bupt.travel.utils.FileUtil;
import com.bupt.travel.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//发送消息相关的服务内容
@Controller
public class MessageControll {

    @Autowired
    ImService imService;


    @RequestMapping(value = "sendMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendMessage(MessageBean message
                        , @RequestParam(value="image",required=false) MultipartFile file
                        , HttpServletRequest request){

        //1.检测参数信息
        if(message.getFromUid() == null || message.getDest() == null){
            return ResponseUtil.error(null, "from_uid和to_uid不能为null");
        }

        //2.判断文本或者图片
        if(message.getType() == IMContants.TEXT_MSG){
            //处理文件信息
            return  null;
        }else if (message.getType() == IMContants.IMAGE_MSG){
            //1.将文件信息存储在本地
            String imageUrl = FileUtil.processImage(file, request);
            //2.文件存储成功返回对应图片的路径信息
            if(!StringUtils.isEmpty(imageUrl)){
                if(imService.sentImageMesage(message.getFromUid(), message.getDest(), imageUrl)){
                    return  ResponseUtil.success(null,"发送成功");
                }else {
                    return  ResponseUtil.error(null,"发送失败");
                }
            }else{
                return ResponseUtil.error(null, "存储失败");
            }
        }else {
            return  ResponseUtil.error(null,"不支持的消息类型");
        }
    }


}
