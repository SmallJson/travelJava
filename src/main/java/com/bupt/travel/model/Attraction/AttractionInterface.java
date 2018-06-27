package com.bupt.travel.model.Attraction;

import com.bupt.travel.utils.JacksonUtil;

public class AttractionInterface {
    /**
     * showapi_res_error :
     * showapi_res_code : 0
     * showapi_res_body : {"ret_code":0,"pagebean":{"allPages":1,"contentlist":[{"proId":"3","summary":"东方古老文明的写照。","cityId":"0","location":{"lon":"116.41704839","lat":"39.88651690"},"priceList":[],"star":"5A","ct":"2015-08-24 17:07:42.353","areaId":"642","id":"4464","proName":"北京","areaName":"东城区","address":"北京市东城区天坛路天桥东侧","name":"天坛公园","picList":[{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/2zR31i.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/2zR31i_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0LTK8w.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0LTK8w_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/FCoVZl.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/FCoVZl_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/kNhWgk.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/kNhWgk_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/cUDyj3.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/cUDyj3_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/Qib7MK.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/Qib7MK_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/catHmF.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/catHmF_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KTooNv.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KTooNv_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/TIJNHQ.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/TIJNHQ_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/df7yqo.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/df7yqo_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/DUSvc1.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/DUSvc1_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KLCjLx.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KLCjLx_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/H26fps.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/H26fps_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/sdNPpV.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/sdNPpV_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aYtyCL.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aYtyCL_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/B8XGsJ.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/B8XGsJ_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/wAtiEe.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/wAtiEe_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aWMSGi.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aWMSGi_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/MybJj5.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/MybJj5_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/qhANLp.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/qhANLp_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/HxdRDW.gif","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/HxdRDW_130x130_00.gif"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KnZnwo.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KnZnwo_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/24/16/lp7s7m.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/24/16/lp7s7m_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0NoA7b.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0NoA7b_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/yWgVTm.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/yWgVTm_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/av8esK.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/av8esK_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/xmYw3I.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/xmYw3I_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/4UVP6k.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/4UVP6k_130x130_00.jpg"}]}],"currentPage":1,"allNum":1,"maxResult":20}}
     */
    private String showapi_res_error;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public  static  ShowapiResBodyBean decode(String json){
        ShowapiResBodyBean bodyBean = new ShowapiResBodyBean();
        if(json == null){
            return bodyBean;
        }
       AttractionInterface attractionInterface = JacksonUtil.readValue(json, AttractionInterface.class);
       return  attractionInterface == null? bodyBean:attractionInterface.getShowapi_res_body();
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * pagebean : {"allPages":1,"contentlist":[{"proId":"3","summary":"东方古老文明的写照。","cityId":"0","location":{"lon":"116.41704839","lat":"39.88651690"},"priceList":[],"star":"5A","ct":"2015-08-24 17:07:42.353","areaId":"642","id":"4464","proName":"北京","areaName":"东城区","address":"北京市东城区天坛路天桥东侧","name":"天坛公园","picList":[{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/2zR31i.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/2zR31i_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0LTK8w.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0LTK8w_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/FCoVZl.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/FCoVZl_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/kNhWgk.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/kNhWgk_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/cUDyj3.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/cUDyj3_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/Qib7MK.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/Qib7MK_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/catHmF.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/catHmF_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KTooNv.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KTooNv_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/TIJNHQ.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/TIJNHQ_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/df7yqo.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/df7yqo_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/DUSvc1.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/DUSvc1_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KLCjLx.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KLCjLx_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/H26fps.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/H26fps_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/sdNPpV.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/sdNPpV_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aYtyCL.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aYtyCL_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/B8XGsJ.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/B8XGsJ_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/wAtiEe.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/wAtiEe_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aWMSGi.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aWMSGi_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/MybJj5.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/MybJj5_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/qhANLp.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/qhANLp_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/HxdRDW.gif","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/HxdRDW_130x130_00.gif"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KnZnwo.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KnZnwo_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/24/16/lp7s7m.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/24/16/lp7s7m_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0NoA7b.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0NoA7b_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/yWgVTm.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/yWgVTm_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/av8esK.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/av8esK_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/xmYw3I.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/xmYw3I_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/4UVP6k.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/4UVP6k_130x130_00.jpg"}]}],"currentPage":1,"allNum":1,"maxResult":20}
         */

        private int ret_code;
        private PageBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PageBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PageBean pagebean) {
            this.pagebean = pagebean;
        }
    }
}
