package com.example.administrator.jiayan_project.enity.mine;

import java.util.List;

/**
 * Created by Administrator on 2018/7/10/010.
 */

public class JifenMainBean {

    private List<DataBean> data;
    private List<IntegralBean> integral;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<IntegralBean> getIntegral() {
        return integral;
    }

    public void setIntegral(List<IntegralBean> integral) {
        this.integral = integral;
    }

    public static class DataBean {
        /**
         * id : 5
         * score : 0
         */

        private int id;
        private int score;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static class IntegralBean {
        /**
         * id : 68
         * name : 10元抵扣券
         * price : 0
         * integralprice : 5
         * originalimg : /static/img/integral_img/5b23751596d09.jpg
         * storecount : 100
         */

        private int id;
        private String name;
        private int price;
        private int integralprice;
        private String originalimg;
        private int storecount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getIntegralprice() {
            return integralprice;
        }

        public void setIntegralprice(int integralprice) {
            this.integralprice = integralprice;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }

        public int getStorecount() {
            return storecount;
        }

        public void setStorecount(int storecount) {
            this.storecount = storecount;
        }
    }
}
