package com.bupt.travel.service;

import com.bupt.travel.dao.TravelDao;
import com.bupt.travel.mapper.UserInfoMapper;
import com.bupt.travel.mapper.UserMapper;
import com.bupt.travel.model.*;
import com.bupt.travel.model.requestBean.*;
import com.bupt.travel.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public boolean insertTravel(TravelTotalBean travelTotalBean){

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

        //将信息插入到所有的目标对象中
        for(Integer toId : uidList){
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
            travelTotal.setFromUid(travelTotalBean.getFromUid());
            travelTotal.setToUid(toId);
            travelDao.insertTravel(travelTotal);

            //2.插入TravelDay信息
            //2.获取自增长id
            if(travelTotalBean.getTravelDayMap() == null) {
                return  false;
            }

            Integer xingchengId = travelTotal.getId();
            updataTravelDay(travelTotalBean,xingchengId);
        }

        //发送一条消息给分享对象
        //1.通过id查询分享人姓名
        UserInfo userInfo =infoMapper .selectUserInfoByUid(travelTotalBean.fromUid);
        //3.拼接分享消息
        String msg = userInfo.getName()+"指定了一条新行程";
        imService.sendTextMessage(userInfo.getName(), travelTotalBean.getPhone(), msg);
        System.out.println("已经分享一条消息");
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

            Place place = new Place();
            place.setId(travelDayId);

            House house = new House();
            house.setId(travelDayId);

            Res res = new Res();
            res.setId(travelDayId);

            if(dayBean != null){
                traffic = filterTraffic(dayBean.getTrafficBean(), traffic);
                res = filterRes(dayBean.getResBean(), res);
                house =filterHouse(dayBean.getHouseBean(), house);
                place = filterPlace(dayBean.getPlaceBean(), place);
            }
            travelDao.insertTraffic(traffic);
            travelDao.insertPlace(place);
            travelDao.insertHouse(house);
            travelDao.insertRes(res);
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

    private Traffic filterTraffic(TrafficBean trafficBean, Traffic traffic){
        if(null != trafficBean){
            traffic.setFlight(trafficBean.getFlightName());
            traffic.setEndPlace(trafficBean.getEndPlace());
            traffic.setStartPlace(trafficBean.getStartPlace());
            traffic.setStartTime(trafficBean.getStartTime());
        }
        return traffic;
    }
    private Place filterPlace(PlaceBean placeBean, Place place){
        if(null != placeBean){
            place.setPlayTime(placeBean.getPlaceName());
            place.setPlaceName(placeBean.getPlayTime());
        }
        return place;
    }

    private  House filterHouse(HouseBean houseBean, House house){
        if(null != null){
            house.setHouseName(houseBean.getHouseName());
            house.setHouseAddress(houseBean.getHouseAddress());
        }
        return house;
    }

    private Res filterRes(ResBean resBean , Res res){
        if(null != resBean){
            res.setResName(resBean.getResName());
            res.setResAddress(resBean.getResAddress());
        }
        return  res;
    }
}
