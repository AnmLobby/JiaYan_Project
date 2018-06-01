package com.example.administrator.jiayan_project.enity.banquet;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public class BanquetBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * dinnername : 鸿门宴
         * subname : 项羽鸿门设宴
         * originprice : 5656
         * price : 999
         * salesum : 999
         * storecount : 99
         * unit : 1
         * state : 1
         * comment : 换个地方
         * originalimg : /static/img/dinner_img/1c32385f012ab97b02f8a91ee7d3fddd.jpg
         * guige : 2
         * cookerid : 1
         * score : 99
         * type : 10
         * categoryid : 1
         * sort : 0
         * huishou : 1
         * time : 1526278634
         * label : 1
         * bigtype : 1
         * edittime : null
         * dinggou : 最大的能接2000桌，最少1桌起订(酒席宴席类)
         * fuwu : 它是指当不可预见的发展导致一产品的进口数量增加，以致对生产同类或直接竞争产品的国内产业造成严重损害或严重损害威胁时，进口成员方可以在非歧视原则的基础上对该产品的进口实施限制。
         * tuikuan : 京东在线支付及POS机刷卡支付订单退款，如涉及到银行信息京东会依据银行及相关机构已经建立的条例处理退款，为了保证客户账户金额的安全，我们均会安排原卡原退
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
        private int type;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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
}
