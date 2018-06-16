package com.bupt.travel.model.requestBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/30 0030.
 * 一天中的行程信息
 */
public class TravelDayBean {

    HouseBean houseBean;
    PlaceBean placeBean;
    ResBean resBean;
    TrafficBean trafficBean;
    NoteBean noteBean;

    public HouseBean getHouseBean() {
        return houseBean;
    }

    public void setHouseBean(HouseBean houseBean) {
        this.houseBean = houseBean;
    }

    public PlaceBean getPlaceBean() {
        return placeBean;
    }

    public void setPlaceBean(PlaceBean placeBean) {
        this.placeBean = placeBean;
    }

    public ResBean getResBean() {
        return resBean;
    }

    public void setResBean(ResBean resBean) {
        this.resBean = resBean;
    }

    public TrafficBean getTrafficBean() {
        return trafficBean;
    }

    public void setTrafficBean(TrafficBean trafficBean) {
        this.trafficBean = trafficBean;
    }

    public NoteBean getNoteBean() {
        return noteBean;
    }

    public void setNoteBean(NoteBean noteBean) {
        this.noteBean = noteBean;
    }

    @Override
    public String toString() {
        return "TravelDayBean{" +
                "houseBean=" + houseBean +
                ", placeBean=" + placeBean +
                ", resBean=" + resBean +
                ", trafficBean=" + trafficBean +
                ", noteBean=" + noteBean +
                '}';
    }
}
