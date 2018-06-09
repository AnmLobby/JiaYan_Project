package com.example.administrator.jiayan_project.enity.banquet;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public class BanquetBean {


    private List<DataBean> data;
    private List<SizeBean> size;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<SizeBean> getSize() {
        return size;
    }

    public void setSize(List<SizeBean> size) {
        this.size = size;
    }

    public static class DataBean {
        /**
         * id : 2
         * dinnername : 豪华套餐
         * subname : 触发霸气
         * originprice : 99999
         * price : 9998
         * salesum : 2133
         * storecount : 1
         * unit : 1
         * state : 1
         * comment : 萨达
         * originalimg : /static/img/dinner_img/9c21e2324d244684ec986917b25a829d.jpg
         * guige : 1
         * cookerid : 1
         * score : 1
         * categoryid : 2
         * sort : 0
         * huishou : 1
         * time : 1526279115
         * label : 4
         * bigtype : 1
         * edittime : null
         * dinggou : 最大的能接2000桌，最少1桌起订(酒席宴席类)。
         * fuwu : 宴万家为每一位通过平台下单的顾客朋友购买团体保险，保障服务的食品安全、消防安全、人身安全。
         * tuikuan : 家宴在线支付及POS机刷卡支付订单退款，如涉及到银行信息家宴会依据银行及相关机构已经建立的条例处理退款，为了保证客户账户金额的安全，我们均会安排原卡原退。
         */

        private int id;
        private String dinnername;
        private String subname;
        private int originprice;
        private int price;
        private int salesum;
        private int storecount;
        private int unit;
        private int state;
        private String comment;
        private String originalimg;
        private int guige;
        private int cookerid;
        private int score;
        private int categoryid;
        private int sort;
        private int huishou;
        private int time;
        private int label;
        private int bigtype;
        private Object edittime;
        private String dinggou;
        private String fuwu;
        private String tuikuan;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDinnername() {
            return dinnername;
        }

        public void setDinnername(String dinnername) {
            this.dinnername = dinnername;
        }

        public String getSubname() {
            return subname;
        }

        public void setSubname(String subname) {
            this.subname = subname;
        }

        public int getOriginprice() {
            return originprice;
        }

        public void setOriginprice(int originprice) {
            this.originprice = originprice;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSalesum() {
            return salesum;
        }

        public void setSalesum(int salesum) {
            this.salesum = salesum;
        }

        public int getStorecount() {
            return storecount;
        }

        public void setStorecount(int storecount) {
            this.storecount = storecount;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }

        public int getGuige() {
            return guige;
        }

        public void setGuige(int guige) {
            this.guige = guige;
        }

        public int getCookerid() {
            return cookerid;
        }

        public void setCookerid(int cookerid) {
            this.cookerid = cookerid;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(int categoryid) {
            this.categoryid = categoryid;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getHuishou() {
            return huishou;
        }

        public void setHuishou(int huishou) {
            this.huishou = huishou;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public int getBigtype() {
            return bigtype;
        }

        public void setBigtype(int bigtype) {
            this.bigtype = bigtype;
        }

        public Object getEdittime() {
            return edittime;
        }

        public void setEdittime(Object edittime) {
            this.edittime = edittime;
        }

        public String getDinggou() {
            return dinggou;
        }

        public void setDinggou(String dinggou) {
            this.dinggou = dinggou;
        }

        public String getFuwu() {
            return fuwu;
        }

        public void setFuwu(String fuwu) {
            this.fuwu = fuwu;
        }

        public String getTuikuan() {
            return tuikuan;
        }

        public void setTuikuan(String tuikuan) {
            this.tuikuan = tuikuan;
        }
    }

    public static class SizeBean {
        /**
         * id : 1
         * sname : 普通紫色
         */

        private int id;
        private String sname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }
    }
}
