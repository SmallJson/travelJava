package com.bupt.travel.service;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.dao.MessageDao;
import com.bupt.travel.dao.UserDao;
import com.bupt.travel.mapper.UserInfoMapper;
import com.bupt.travel.model.IM.*;
import com.bupt.travel.model.Message;
import com.bupt.travel.model.User;
import com.bupt.travel.model.UserInfo;
import com.bupt.travel.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImService extends BaseService {

    @Autowired
    UserInfoMapper infoMapper;
    @Autowired
    MessageDao  messageDao;
    @Autowired
    UserDao userDao;
    public ImService() {
        urlMap.put("uploadFile", "http://a1.easemob.com/1148180614146538/travel/chatfiles");
        urlMap.put("Message", "http://a1.easemob.com/1148180614146538/travel/messages");
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
     * @param  fromUid 消息的发送者
     * @pram destUser 目标用户
     * @param content 文本信息的内容
     */
    @Transactional
    public void sendTextMessage(Integer fromUid, String destUser,String content){
        UserInfo userInfo = infoMapper.selectUserInfoByUid(fromUid);

        String []dest = destUser.split(",");

        //保存消息记录
        for(int i = 0 ;i< dest.length;i++){
            //1.通过目标的账号，找到目标uid
            int toUid = userDao.selectIdByPhone(dest[i]);
            //2.构造数据库消息记录
            Message message = new Message();
            message.setCreatTime(System.currentTimeMillis()+"");
            message.setType(IMContants.TEXT_MSG);
            message.setFromUid(fromUid);
            message.setToUid(toUid);
            message.setText(content);
            message.setFromAvator(userInfo.getAvator());
            message.setFromName(userInfo.getName());
            message.setReadType(IMContants.IM_UNREAD);
            messageDao.insertMesssage(message);

            //3.通过IM发送消息
            Map<String ,Object> param = new HashMap<>();
            param.put("target_type", "users");
            param.put("target",dest);
            TextMessage msg = new TextMessage();
            msg.setType("txt");
            msg.setMsg(content);
            param.put("msg",msg);
            param.put("from", userInfo.getName());
            Extra extra = new Extra();
            extra.setType(IMContants.TEXT_MSG);
            extra.setCreatTime(TimeUtil.UnixToDate(System.currentTimeMillis()+""));
            extra.setAvator(userInfo.getAvator());
            extra.setFromUid(fromUid);
            extra.setToUid(toUid);
            extra.setFromName(userInfo.getName());
            extra.setId(message.getId());
            extra.setRead(IMContants.IM_UNREAD);
            param.put("ext",extra);

            Map<String, Object> header = new HashMap<>();
            String json = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param, header);
            System.out.println(json);
        }
    }


    /**
     * 发送图片信息
     * @param fromUid
     * @param destUser
     * @param imageUrl
     * @return
     */
    @Transactional
    public boolean sentImageMesage(Integer placeId,Integer fromUid, String destUser, String imageUrl){
        System.out.println(imageUrl);
        //1. 获取发送者姓名
        UserInfo userInfo = infoMapper.selectUserInfoByUid(fromUid);

        //2.自定义消息结构发送给目标用户
        String []dest = destUser.split(",");

        //3.将将成功发送的消息，存储到数据库中
        //保存消息记录
        for(int i = 0 ;i< dest.length;i++){
            //4.通过目标的账号，找到目标uid
            int toUid = userDao.selectIdByPhone(dest[i]);
            Message message = new Message();
            message.setCreatTime(System.currentTimeMillis()+"");
            message.setType(IMContants.IMAGE_MSG);
            message.setFromUid(fromUid);
            message.setToUid(toUid);
            message.setText("发送一张图片");
            message.setImgUrl(imageUrl);
            message.setFromAvator(userInfo.getAvator());
            message.setFromName(userInfo.getName());
            message.setReadType(IMContants.IM_UNREAD);
            message.setPlaceId(placeId);
            //保存消息记录
            messageDao.insertMesssage(message);

            //5.构造IM消息记录
            Map<String ,Object> param = new HashMap<>();
            param.put("target_type", "users");
            param.put("target",dest);
            TextMessage msg = new TextMessage();
            msg.setType("txt");
            msg.setMsg("扩展的图片消息");
            param.put("msg",msg);
            param.put("from", userInfo.getName());
            Extra extra = new Extra();
            extra.setType(IMContants.IMAGE_MSG);
            extra.setUrl(imageUrl);
            extra.setCreatTime(TimeUtil.UnixToDate(System.currentTimeMillis()+""));
            extra.setAvator(userInfo.getAvator());
            extra.setFromUid(fromUid);
            extra.setFromName(userInfo.getName());
            extra.setToUid(toUid);
            extra.setText("发送一张图片");
            extra.setId(message.getId());
            extra.setRead(IMContants.IM_UNREAD);
            param.put("ext",extra);
            //发送IM消息
            String result = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param,null);
            System.out.println(result);
            if(StringUtils.isEmpty(result)){
                return  false;
            }
        }
        return true;
    }

    /**
     * 发送行程信息
     */
    public boolean sentTravelMessage(Integer fromUid,String avator, String fromUser, String destUser,String content,Integer travelId){
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
        extra.setType(IMContants.TRAVEL_MSG);
        extra.setCreatTime(TimeUtil.UnixToDate(System.currentTimeMillis()+""));
        extra.setTravelId(travelId);
        extra.setAvator(avator);
        int toUid = userDao.selectIdByPhone(destUser);
        extra.setToUid(toUid);
        extra.setFromUid(fromUid);
        extra.setFromName(fromUser);
        extra.setText(fromUser+"指定一条行程");
        extra.setRead(IMContants.IM_UNREAD);
        param.put("ext",extra);

        Map<String, Object> header = new HashMap<>();
        String json = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param, header);
        System.out.println(json);

        return  true;
    }

    public boolean sendTravelMessage(String fromUser,String[] dest,Message message){
        Map<String ,Object> param = new HashMap<>();
        param.put("target_type", "users");
      /*String []dest = destUser.split(",");*/
        param.put("target",dest);
        TextMessage msg = new TextMessage();
        msg.setType("txt");
        msg.setMsg(message.getText());
        param.put("msg",msg);
        param.put("from", fromUser);

        Extra extra = new Extra();
        extra.setType(IMContants.TRAVEL_MSG);
        extra.setCreatTime(TimeUtil.UnixToDate(System.currentTimeMillis()+""));
        extra.setTravelId(message.getTravelId());
        extra.setAvator(message.getFromAvator());
        extra.setToUid(message.getToUid());
        extra.setFromUid(message.getFromUid());
        extra.setFromName(message.getFromName());
        extra.setText(message.getFromName()+"指定一条行程");
        extra.setRead(IMContants.IM_UNREAD);
        extra.setId(message.getId());
        param.put("ext",extra);

        Map<String, Object> header = new HashMap<>();
        String json = restTemplateUtil.doPostWithToken(urlMap.get("Message"), param, header);
        System.out.println(json);

        return  true;
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

    /**
     * 查询指定user_id下的消息
     * @param toUid
     * @return
     */
    public List<Message> selectMessageBytoUid(Integer toUid){
        return  messageDao.selectMessage(toUid);
    }

    /**
     * 修改某条消息状态
     * 默认从未读消息修改成已读消息
     */
    @Transactional
    public Integer updataMessage(int messageId){
       Integer count = messageDao.updateMessageRead(IMContants.IM_READ, messageId);
       return  count;
    }

    /**
     * 查询未读消息总数
     */
    public Integer selectUnReadMsg(Integer toUid){
        Integer count = messageDao.selectUnReadMessage(IMContants.IM_UNREAD, toUid);
        return  count;
    }

}
