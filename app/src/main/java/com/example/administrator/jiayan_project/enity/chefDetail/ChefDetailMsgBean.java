package com.example.administrator.jiayan_project.enity.chefDetail;

import java.util.List;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ChefDetailMsgBean {


    private List<ChefDataBean> chefData;
    private List<CookBean> cook;

    public List<ChefDataBean> getChefData() {
        return chefData;
    }

    public void setChefData(List<ChefDataBean> chefData) {
        this.chefData = chefData;
    }

    public List<CookBean> getCook() {
        return cook;
    }

    public void setCook(List<CookBean> cook) {
        this.cook = cook;
    }

    public static class ChefDataBean {
        /**
         * id : 1
         * honor_id : 1
         * rank_id : 1
         * cookage : 10
         * salesum : 100
         * subname : 很好很帅气
         * price : 888
         * cookimg : /static/img/cook_img/5b1e1f7b6b6b2.jpg
         * yueprice : 88888
         * nianprice : 888888
         * certificates : 1
         * cookfront : 0
         * dietionfront : 1
         * other : 1
         * cuisine : 广东菜系
         * rankname : 助理营养师
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
        private int certificates;
        private int cookfront;
        private int dietionfront;
        private int other;
        private String cuisine;
        private String rankname;

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

        public int getCertificates() {
            return certificates;
        }

        public void setCertificates(int certificates) {
            this.certificates = certificates;
        }

        public int getCookfront() {
            return cookfront;
        }

        public void setCookfront(int cookfront) {
            this.cookfront = cookfront;
        }

        public int getDietionfront() {
            return dietionfront;
        }

        public void setDietionfront(int dietionfront) {
            this.dietionfront = dietionfront;
        }

        public int getOther() {
            return other;
        }

        public void setOther(int other) {
            this.other = other;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public String getRankname() {
            return rankname;
        }

        public void setRankname(String rankname) {
            this.rankname = rankname;
        }
    }

    public static class CookBean {
        /**
         * id : 1
         * titlename : 中式营养师
         * cookerimg : /assets/cook/5b20dcc304806.png
         */

        private int id;
        private String titlename;
        private String cookerimg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitlename() {
            return titlename;
        }

        public void setTitlename(String titlename) {
            this.titlename = titlename;
        }

        public String getCookerimg() {
            return cookerimg;
        }

        public void setCookerimg(String cookerimg) {
            this.cookerimg = cookerimg;
        }
    }
}
