package com.example.administrator.jiayan_project.enity.chefDetail;

import java.util.List;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ChefDetailMsgBean {


    private List<ChefDataBean> chefData;
    private List<CookBean> cook;
    private List<String> yii;

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

    public List<String> getYii() {
        return yii;
    }

    public void setYii(List<String> yii) {
        this.yii = yii;
    }

    public static class ChefDataBean {
        /**
         * id : 2
         * honor_id : 5
         * rank_id : 4
         * cookage : 100
         * salesum : 5004
         * subname : 做菜超好吃特别有营养很好
         * price : 999
         * cookimg : /static/img/cook_img/5b1e38e030266.jpg
         * banprice : 99999
         * nianprice : 999999
         * certificates : 1
         * cookfront : 1
         * dietionfront : 0
         * other : 1
         * cuisine : 客家菜系
         * cookname : 小往
         */

        private int id;
        private int honor_id;
        private int rank_id;
        private int cookage;
        private int salesum;
        private String subname;
        private int price;
        private String cookimg;
        private int banprice;
        private int nianprice;
        private int certificates;
        private int cookfront;
        private int dietionfront;
        private int other;
        private String cuisine;
        private String cookname;

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

        public int getBanprice() {
            return banprice;
        }

        public void setBanprice(int banprice) {
            this.banprice = banprice;
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

        public String getCookname() {
            return cookname;
        }

        public void setCookname(String cookname) {
            this.cookname = cookname;
        }
    }

    public static class CookBean {
        /**
         * id : 5
         * titlename : 中式烹调师
         * cookerimg : /assets/cook/5b20dce58ea95.png
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
