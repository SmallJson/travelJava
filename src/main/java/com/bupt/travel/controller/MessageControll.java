package com.bupt.travel.controller;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.model.Message;
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
import java.util.List;
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
            imService.sendTextMessage(message.getFromUid(),message.getDest(),message.getText());
            return  ResponseUtil.success("","发送成功");
        }else if (message.getType() == IMContants.IMAGE_MSG){
            //1.将文件信息存储在本地
            String imageUrl = FileUtil.processImage(file, request);
            //2.文件存储成功返回对应图片的路径信息
            if(!StringUtils.isEmpty(imageUrl)){
                if(imService.sentImageMesage(message.getPlaceId(),message.getFromUid(), message.getDest(), imageUrl)){
                    return  ResponseUtil.success(imageUrl,"发送成功");
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

    //查询收到的各种消息
    @RequestMapping(value = "selectMessage",method =RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectMessage(@RequestParam(required = true) Integer toUid){
       List<Message> list = imService.selectMessageBytoUid(toUid);
       if(list!=null){
           return  ResponseUtil.success(list,"查询成功");
       }else{
           return  ResponseUtil.error(list,"查询失败");
       }
    }


    /**
     * 更新消息状态
     * @param id
     * @return
     */
    @RequestMapping(value = "updateMsgStatus", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String ,Object> updataMessageReadStatus(@RequestParam(required = true)Integer id
                                                        ,@RequestParam(required = true) Integer toUid){

        System.out.println("进入更新方法");
        //更新消息状态
        Integer count = imService.updataMessage(id);
        if(count == null || count < 1){
            return  ResponseUtil.error(null,"更新消息为已读失败");
        }

        //查询消息未读条数
        Integer UnReadCount = imService.selectUnReadMsg(toUid);
        if(UnReadCount == null || UnReadCount < 0){
            return  ResponseUtil.error(null,"查询未读消息失败");
        }

        return  ResponseUtil.success(UnReadCount,"更新成功,并返回未读消息条数");
    }


    /**
     * 查询未读消息数量
     * @param toUid
     * @return
     */
    @RequestMapping(value = "selectUnReadMsg", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectUnRead(@RequestParam(required = true) Integer toUid){
        Integer count = imService.selectUnReadMsg(toUid);
        if(count == null || count < 1){
            return  ResponseUtil.error(null,"更新消息为已读失败");
        }else{
            return  ResponseUtil.success(count, "更新消息为已读成功");
        }
    }

}
