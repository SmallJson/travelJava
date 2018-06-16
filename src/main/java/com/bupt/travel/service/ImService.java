package com.bupt.travel.service;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.mapper.UserInfoMapper;
import com.bupt.travel.model.IM.*;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.utils.JacksonUtil;
import com.bupt.travel.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class ImService extends BaseService {

    @Autowired
    UserInfoMapper infoMapper;

    public ImService() {
        urlMap.put("uploadFile", "https://a1.easemob.com/1148180614146538/travel/chatfiles");
        urlMap.put("Message", "https://a1.easemob.com/1148180614146538/travel/messages");
    }


    /* {
        "target_type" : "users", // users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
            "target" : ["u1", "u2", "u3"], // 注意这里需要用数组，数组长度建议不大于20，即使只有一个用户，
        // 也要用数组 ['u1']，给用户发送时数组元素是用户名，给群组发送时
        // 数组元素是groupid
        "msg" : {
        "type" : "txt",
                "msg" : "hello from rest" //消息内容，参考[[start:100serverintegration:30chatlog|聊天记录]]里的bodies内容
    },
        "from" : "jma2" //表示消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
    }*/
    /**
     * @param  fromUser 消息的发送者
     * @pram destUser 目标用户
     * @param content 文本信息的内容
     */
    public void sendTextMessage(String fromUser, String destUser,String content){
        Map<String ,Object> param = new HashMap<>();
        param.put("target_type", "users");
        String []dest = destUser.split(",");
        param.put("target",dest);
        TextMessage msg = new TextMessage();
        msg.setType("txt");
        msg.setMsg(content);
        param.put("msg",msg);
        param.put("from", fromUser);
        Extra extra = new Extra();
        extra.setType(IMContants.TEXT_MSG);
        extra.setCreatTime(System.currentTimeMillis());
        param.put("ext",extra);

        Map<String, Object> header = new HashMap<>();
        String json = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param, header);
        System.out.println(json);
    }

    /**
     * 发送图片信息
     * @param fromUid
     * @param destUser
     * @param imageUrl
     * @return
     */
    public boolean sentImageMesage(Integer fromUid, String destUser, String imageUrl){
        System.out.println(imageUrl);
        //1. 获取发送者姓名
        UserInfo userInfo = infoMapper.selectUserInfoByUid(fromUid);

        //3.自定义消息结构发送给目标用户
        String [] phone = destUser.split(",");
        Map<String ,Object> param = new HashMap<>();
        param.put("target_type", "users");
        String []dest = destUser.split(",");
        param.put("target",dest);
        TextMessage msg = new TextMessage();
        msg.setType("txt");
        msg.setMsg("扩展的图片消息");
        param.put("msg",msg);
        param.put("from", userInfo.getName());
        Extra extra = new Extra();
        extra.setType(IMContants.IMAGE_MSG);
        extra.setUrl(imageUrl);
        extra.setCreatTime(System.currentTimeMillis());
        param.put("ext",extra);
        String result = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param,null);
        System.out.println(result);
        if(StringUtils.isEmpty(result)){
            return  false;
        }
        //4.将将成功发送的消息，存储到数据库中

        return true;
    }



    /**
     * //目前废弃这个方法
     * 发送图片消息
     */
    @Transactional
    public boolean sendImageMessage(Integer fromUid, String destUser,String filePath){
        //1.上传Image到Im服务器,获取图片的uuid以及Secret。
        String json = restTemplateUtil.doPostWithImage(urlMap.get("uploadFile"), filePath);
        ImageEntity entity =  ImageInterface.decode(json);
        if(entity == null ){
            return  false;
        }

        //1.1 获取发送者姓名
        UserInfo userInfo = infoMapper.selectUserInfoByUid(fromUid);

        //2.发送消息给目标用户
        String [] phone = destUser.split(",");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("target_type", "users");
        param.put("target",phone);
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setType("img");
        imageMessage.setFilename(System.currentTimeMillis()+".jpg");
        imageMessage.setUrl(entity.getUuid());
        imageMessage.setSecret(entity.getSharesecret());
        param.put("msg", imageMessage);
        param.put("from",userInfo.getName());

        String result = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param,null);
        System.out.println(result);
        if(StringUtils.isEmpty(result)){
            return  false;
        }
        return true;
        //3.图片保存到七牛云中
        //4.存储消息到本地服务器
    }

}
