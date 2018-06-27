package com.bupt.travel.model.Attraction;

import java.util.List;

public class PageBean {
    /**
     * allPages : 1
     * contentlist : [{"proId":"3","summary":"东方古老文明的写照。","cityId":"0","location":{"lon":"116.41704839","lat":"39.88651690"},"priceList":[],"star":"5A","ct":"2015-08-24 17:07:42.353","areaId":"642","id":"4464","proName":"北京","areaName":"东城区","address":"北京市东城区天坛路天桥东侧","name":"天坛公园","picList":[{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/2zR31i.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/2zR31i_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0LTK8w.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0LTK8w_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/FCoVZl.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/FCoVZl_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/kNhWgk.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/kNhWgk_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/cUDyj3.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/cUDyj3_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/Qib7MK.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/Qib7MK_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/catHmF.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/catHmF_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KTooNv.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KTooNv_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/TIJNHQ.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/TIJNHQ_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/df7yqo.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/df7yqo_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/DUSvc1.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/DUSvc1_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KLCjLx.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KLCjLx_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/H26fps.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/H26fps_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/sdNPpV.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/sdNPpV_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aYtyCL.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aYtyCL_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/B8XGsJ.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/B8XGsJ_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/wAtiEe.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/wAtiEe_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aWMSGi.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/aWMSGi_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/MybJj5.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/MybJj5_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/qhANLp.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/qhANLp_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/HxdRDW.gif","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/HxdRDW_130x130_00.gif"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KnZnwo.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/KnZnwo_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/24/16/lp7s7m.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/24/16/lp7s7m_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0NoA7b.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/0NoA7b_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/yWgVTm.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/yWgVTm_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/av8esK.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/av8esK_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/xmYw3I.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/xmYw3I_130x130_00.jpg"},{"picUrl":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/4UVP6k.jpg","picUrlSmall":"http://pic3.40017.cn/scenery/destination/2015/04/16/07/4UVP6k_130x130_00.jpg"}]}]
     * currentPage : 1
     * allNum : 1
     * maxResult : 20
     */
    private int allPages;
    private int currentPage;
    private int allNum;
    private int maxResult;
    private List<AttractionBean> contentlist;

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public List<AttractionBean> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<AttractionBean> contentlist) {
        this.contentlist = contentlist;
    }

}
