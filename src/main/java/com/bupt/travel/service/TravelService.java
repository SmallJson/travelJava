package com.bupt.travel.service;

import com.bupt.travel.contant.IMContants;
import com.bupt.travel.contant.ModelContants;
import com.bupt.travel.dao.MessageDao;
import com.bupt.travel.dao.TravelDao;
import com.bupt.travel.mapper.UserInfoMapper;
import com.bupt.travel.mapper.UserMapper;
import com.bupt.travel.model.*;
import com.bupt.travel.model.requestBean.*;
import com.bupt.travel.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.resources.Messages_de;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelService extends BaseService{

    @Autowired
    TravelDao travelDao;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper infoMapper;
    @Autowired
    ImService imService;

    @Autowired
    MessageDao messageDao;

    @Transactional
    public boolean insertTravel(TravelTotalBean travelTotalBean){
        //发送一条消息给分享对象
        //1.通过id查询分享人姓名
        UserInfo userInfo =infoMapper .selectUserInfoByUid(travelTotalBean.fromUid);
        //2.拼接分享消息
        String msg = userInfo.getName()+"指定了一条新行程";

        //存储行程消息
        List<Message> messageList = new ArrayList<>();

        //分离手机号码
        String [] phones = travelTotalBean.getPhone().split(",");
        List<Integer> uidList = new ArrayList<>();

        //查询目标对象的所有id
        for(int i = 0 ;i < phones.length ; i++){
            //0.依据对象手机号查询对象id
            Integer toId = userMapper.selectIdByPhone(travelTotalBean.getPhone());
            if(toId == null){
                return  false;
            }
            uidList.add(toId);
        }

        if(travelTotalBean.getTravelBean() == null){
            return false;
        }

        Integer xingchengId =0;
        //将信息插入到所有的目标对象中
        for(int i = 0 ;i < uidList.size(); i++){
            Integer toId = uidList.get(i);
            Message message = new Message();
            message.setFromUid(travelTotalBean.getFromUid());
            message.setToUid(toId);

            //1.插入TravelTotal对象，并且获取TravelTotal对象的id属性
            TravelTotal travelTotal = new TravelTotal();
            travelTotal.setStartPlace(travelTotalBean.getTravelBean().city);
            travelTotal.setTravelName(travelTotalBean.getTravelBean().travelName);
            travelTotal.setStartTime(travelTotalBean.getTravelBean().time);
            travelTotal.setTravelDay(travelTotalBean.getTravelBean().dataCount);
            //类型和阅读类型需要修改成客户端提交
            travelTotal.setType(1);
            travelTotal.setReadType(1);

            travelTotal.setCreatTime(System.currentTimeMillis()+"");
            message.setCreatTime(System.currentTimeMillis()+"");
            message.setType(IMContants.TRAVEL_MSG);
            message.setText(msg);

            travelTotal.setFromUid(travelTotalBean.getFromUid());
            travelTotal.setToUid(toId);
            travelDao.insertTravel(travelTotal);

            //2.插入TravelDay信息
            //2.获取自增长id
            if(travelTotalBean.getTravelDayMap() == null) {
                return  false;
            }
            xingchengId = travelTotal.getId();
            message.setTravelId(xingchengId);
            message.setFromAvator(userInfo.getAvator());
            message.setFromName(userInfo.getName());
            message.setReadType(IMContants.IM_UNREAD);

            updataTravelDay(travelTotalBean,xingchengId);

            messageDao.insertMesssage(message);
            //发送IM消息
           /* boolean result = imService.sentTravelMessage(travelTotalBean.fromUid,userInfo.getAvator(),userInfo.getName(), travelTotalBean.getPhone(), msg, xingchengId);*/
            boolean result = imService.sendTravelMessage(userInfo.getName(), phones, message);
             System.out.println("发送一条行程信息");
        }

        return  true;
    }

    //更新行程信息
    public boolean updateTravel(TravelTotalBean travelTotalBean){
        //依据行程id更新行程信息
        //1.依据行程id修改行程对象
        TravelTotal travelTotal = new TravelTotal();
        travelTotal.setStartPlace(travelTotalBean.getTravelBean().city);
        travelTotal.setTravelName(travelTotalBean.getTravelBean().travelName);
        travelTotal.setStartTime(travelTotalBean.getTravelBean().time);
        travelTotal.setTravelDay(travelTotalBean.getTravelBean().dataCount);
        //类型和阅读类型需要修改成客户端提交
        travelTotal.setType(1);
        travelTotal.setReadType(1);

        travelTotal.setCreatTime(System.currentTimeMillis()+"");
        travelDao.updateTravelDay(travelTotal);

        if(travelTotalBean.getTravelDayMap() == null) {
            return  false;
        }

        Integer xingchengId = travelTotalBean.xingchengId;
        updataTravelDay(travelTotalBean,xingchengId);
        return  true;
    }

    private void updataTravelDay(TravelTotalBean travelTotalBean,Integer xingchengId){
        for(int i = 0;i <travelTotalBean.getTravelBean().dataCount ;i++){
            TravelDay travelDay = new TravelDay();
            travelDay.setXingchengId(xingchengId);
            travelDay.setDay(i+1);
            travelDao.insertTravelDay(travelDay);
            //插入每一天的Traffic以及Place，House以及Res信息
            //获取自增长id
            Integer travelDayId = travelDay.getId();
            int day = i + 1;
            TravelDayBean dayBean = travelTotalBean.getTravelDayMap().get(day+"");

            Traffic traffic = new Traffic();
            traffic.setId(travelDayId);
            traffic.setComplete(ModelContants.UNCOMPLETE);

            Place place = new Place();
            place.setId(travelDayId);
            place.setComplete(ModelContants.UNCOMPLETE);

            House house = new House();
            house.setId(travelDayId);
            house.setComplete(ModelContants.UNCOMPLETE);

            Res res = new Res();
            res.setId(travelDayId);
            res.setComplete(ModelContants.UNCOMPLETE);

            Note note = new Note();
            note.setId(travelDayId);

            if(dayBean != null){
                traffic = filterTraffic(dayBean.getTrafficBean(), traffic);
                res = filterRes(dayBean.getResBean(), res);
                house =filterHouse(dayBean.getHouseBean(), house);
                place = filterPlace(dayBean.getPlaceBean(), place);
                note = filterNote(dayBean.getNoteBean(),note);
            }
            travelDao.insertTraffic(traffic);
            travelDao.insertPlace(place);
            travelDao.insertHouse(house);
            travelDao.insertRes(res);
            travelDao.insertNote(note);
        }
    }

    public List<TravelTotalBean> selectTravel(Integer fromId, Integer toId, Integer type,Integer readType){
        //1.查询用户名下的所有行程id
        List<TravelTotal> list = travelDao.selectTravel(fromId,toId,type,readType);
        List<TravelTotalBean> resultList = new ArrayList<TravelTotalBean>();

        for(int i =0 ;i < list.size(); i++){
            //0.获取分享人的id
            Integer fromUid = list.get(i).getFromUid();
            //利用分享人id查询分享人信息
            UserInfo userInfo = infoMapper.selectUserInfoByUid(fromUid);

            //1.赋值
            TravelTotalBean travelTotalBean = new TravelTotalBean();
            //赋值分享人信息
            travelTotalBean.setFromAvator(userInfo.getAvator());
            travelTotalBean.setFromName(userInfo.getName());
            //赋值行程id
            travelTotalBean.setXingchengId(list.get(i).getId());

            //1.赋值行程的总体信息
            travelTotalBean.getTravelBean().dataCount = list.get(i).travelDay;
            travelTotalBean.getTravelBean().time = list.get(i).startTime;
            travelTotalBean.getTravelBean().travelName = list.get(i).travelName;
            travelTotalBean.getTravelBean().city = list.get(i).startPlace;
            travelTotalBean.getTravelBean().creatTime = TimeUtil.UnixToDate(list.get(i).creatTime);
            //查询每一天的行程信息
            for(int j = 1; j <= list.get(i).getTravelDay();j++){
                TravelDay travelDay = new TravelDay();
                travelDay.setDay(j);
                travelDay.setXingchengId(list.get(i).getId());
                TravelDayBean travelDayBean = travelDao.selectTravelDay(travelDay);
                travelTotalBean.getTravelDayMap().put(j+"",travelDayBean);
            }
            //查询结果放入resultList中
            resultList.add(travelTotalBean);
        }
        return resultList;
    }

    public TravelTotalBean selectTravelById(Integer travelId){
        //查询行程总体信息
        TravelTotal travelTotal = travelDao.selectTraveTotalById(travelId);

        //0.获取分享人的id
        Integer fromUid = travelTotal.getFromUid();
        //利用分享人id查询分享人信息
        UserInfo userInfo = infoMapper.selectUserInfoByUid(fromUid);
        //获取分享人手机号码
        String sharePhone= userMapper.selectPhoneByUid(fromUid);

        //1.赋值
        TravelTotalBean travelTotalBean = new TravelTotalBean();
        //赋值分享人信息
        travelTotalBean.setFromAvator(userInfo.getAvator());
        travelTotalBean.setFromName(userInfo.getName());
        travelTotalBean.setSharePhone(sharePhone);
        //赋值行程id
        travelTotalBean.setXingchengId(travelTotal.getId());

        //1.赋值行程的总体信息
        travelTotalBean.getTravelBean().dataCount = travelTotal.travelDay;
        travelTotalBean.getTravelBean().time = travelTotal.startTime;
        travelTotalBean.getTravelBean().travelName = travelTotal.travelName;
        travelTotalBean.getTravelBean().city = travelTotal.startPlace;
        travelTotalBean.getTravelBean().creatTime = TimeUtil.UnixToDate(travelTotal.creatTime);
        //查询每一天的行程信息
        for(int j = 1; j <= travelTotal.getTravelDay();j++){
            TravelDay travelDay = new TravelDay();
            travelDay.setDay(j);
            travelDay.setXingchengId(travelTotal.getId());
            TravelDayBean travelDayBean = travelDao.selectTravelDay(travelDay);
            travelTotalBean.getTravelDayMap().put(j+"",travelDayBean);
        }
        return travelTotalBean;
    }

    private Traffic filterTraffic(TrafficBean trafficBean, Traffic traffic){
        if(null != trafficBean){
            traffic.setFlight(trafficBean.getFlightName());
            traffic.setEndPlace(trafficBean.getEndPlace());
            traffic.setStartPlace(trafficBean.getStartPlace());
            traffic.setStartTime(trafficBean.getStartTime());
            traffic.setImg(trafficBean.getImg());
        }
        return traffic;
    }

    private Place filterPlace(PlaceBean placeBean, Place place){
        if(null != placeBean){
            place.setPlayTime(placeBean.getPlaceName());
            place.setPlaceName(placeBean.getPlayTime());
            place.setImg(placeBean.getImg());
        }
        return place;
    }

    private  House filterHouse(HouseBean houseBean, House house){
        if(houseBean != null){
            house.setHouseName(houseBean.getHouseName());
            house.setHouseAddress(houseBean.getHouseAddress());
            house.setImg(houseBean.getImg());
        }
        return house;
    }

    private Res filterRes(ResBean resBean , Res res){
        if(null != resBean){
            res.setResName(resBean.getResName());
            res.setResAddress(resBean.getResAddress());
            res.setImg(resBean.getImg());
        }
        return  res;
    }

    private Note filterNote(NoteBean noteBean, Note note){
        if(null != noteBean){
            note.setTitle(noteBean.getTitle());
            note.setContent(noteBean.getContent());
            note.setImg(noteBean.getImg());
        }
        return note;
    }


    /**
     * 更新具体行程完成度信息
     */
    @Transactional
    public int updataComplete(int id , int type){
        //1.更新消息状态
        int  result = -1;
        switch (type){
            case ModelContants.HOUSE:
                result = travelDao.updateHouseComplete(id, ModelContants.COMPLETE);
                break;
            case ModelContants.TRAFFIC:
                result = travelDao.updateTrafficComplete(id, ModelContants.COMPLETE);
                break;
            case ModelContants.RES:
                result = travelDao.updateResComplete(id, ModelContants.COMPLETE);
                break;
            case ModelContants.PLACE:
                result = travelDao.updatePlaceComplete(id, ModelContants.COMPLETE);
                break;
            default:
                break;
        }
        return  result;
    }
}
