package com.bupt.travel.model.Map;

import com.bupt.travel.utils.JacksonUtil;

import java.util.List;

public class LocationInterface {

    /**
     * status : 0
     * message : ok
     * result : [{"source":"baidu","location":{"lat":39.88783523782654,"lng":116.41578469886984},"bound":"39.880736,116.407118;39.894480,116.427018","formatted_address":"北京市东城区","address_components":{"province":"北京市","city":"北京市","district":"东城区","street":"","level":"旅游景点"},"precise":0.3}]
     */
    private int status;
    private String message;
    private List<ResultBean> result;


    public  static List<ResultBean> decode(String json){
        if(json == null){
            return  new LocationInterface().getResult();
        }
        LocationInterface locationInterface = JacksonUtil.readValue(json, LocationInterface.class);
        return locationInterface.getResult();
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * source : baidu
         * location : {"lat":39.88783523782654,"lng":116.41578469886984}
         * bound : 39.880736,116.407118;39.894480,116.427018
         * formatted_address : 北京市东城区
         * address_components : {"province":"北京市","city":"北京市","district":"东城区","street":"","level":"旅游景点"}
         * precise : 0.3
         */

        private String source;
        private LocationBean location;
        private String bound;
        private String formatted_address;
        private AddressComponentBean address_components;
        private double precise;

        public AddressComponentBean getAddress_components() {
            return address_components;
        }

        public void setAddress_components(AddressComponentBean address_components) {
            this.address_components = address_components;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getBound() {
            return bound;
        }

        public void setBound(String bound) {
            this.bound = bound;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }



        public double getPrecise() {
            return precise;
        }

        public void setPrecise(double precise) {
            this.precise = precise;
        }
    }
}
