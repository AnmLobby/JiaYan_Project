package com.example.administrator.jiayan_project.enity.chef;

import java.util.List;

/**
 * Created by Administrator on 2018/6/11/011.
 */

public class ChefMsgBean {

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
         * honor_id : 2
         * rank_id : 1
         * cookage : 10
         * salesum : 100
         * subname : 很好很帅气
         * price : 888
         * cookimg : /static/img/cook_img/5b1e1f7b6b6b2.jpg
         * yueprice : 88888
         * nianprice : 888888
         * rankname : 助理营养师
         * titlename : 中式面点师
         */

        private int id;
        private int honor_id;
        private int rank_id;
        private int cookage;
        private int salesum;
        private String subname;
        private int price;
        private String cookimg;
        private int yueprice;
        private int nianprice;
        private String rankname;
        private String titlename;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getHonor_id() {
            return honor_id;
        }

        public void setHonor_id(int honor_id) {
            this.honor_id = honor_id;
        }

        public int getRank_id() {
            return rank_id;
        }

        public void setRank_id(int rank_id) {
            this.rank_id = rank_id;
        }

        public int getCookage() {
            return cookage;
        }

        public void setCookage(int cookage) {
            this.cookage = cookage;
        }

        public int getSalesum() {
            return salesum;
        }

        public void setSalesum(int salesum) {
            this.salesum = salesum;
        }

        public String getSubname() {
            return subname;
        }

        public void setSubname(String subname) {
            this.subname = subname;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getCookimg() {
            return cookimg;
        }

        public void setCookimg(String cookimg) {
            this.cookimg = cookimg;
        }

        public int getYueprice() {
            return yueprice;
        }

        public void setYueprice(int yueprice) {
            this.yueprice = yueprice;
        }

        public int getNianprice() {
            return nianprice;
        }

        public void setNianprice(int nianprice) {
            this.nianprice = nianprice;
        }

        public String getRankname() {
            return rankname;
        }

        public void setRankname(String rankname) {
            this.rankname = rankname;
        }

        public String getTitlename() {
            return titlename;
        }

        public void setTitlename(String titlename) {
            this.titlename = titlename;
        }
    }
}
