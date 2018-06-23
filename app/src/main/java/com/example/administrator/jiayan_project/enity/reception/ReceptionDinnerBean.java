package com.example.administrator.jiayan_project.enity.reception;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionDinnerBean {

    private List<ReceptionBean> reception;
    private List<CookoBean> cooko;

    public List<ReceptionBean> getReception() {
        return reception;
    }

    public void setReception(List<ReceptionBean> reception) {
        this.reception = reception;
    }

    public List<CookoBean> getCooko() {
        return cooko;
    }

    public void setCooko(List<CookoBean> cooko) {
        this.cooko = cooko;
    }

    public static class ReceptionBean {
        /**
         * id : 17
         * price : 6889
         * dinnername : 奥斯丁
         * salesum : 45667
         * originalimg : /static/img/dinner_img/9c21e2124d244684ec926917b25a897d.jpg
         */

        private int id;
        private int price;
        private String dinnername;
        private int salesum;
        private String originalimg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDinnername() {
            return dinnername;
        }

        public void setDinnername(String dinnername) {
            this.dinnername = dinnername;
        }

        public int getSalesum() {
            return salesum;
        }

        public void setSalesum(int salesum) {
            this.salesum = salesum;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }
    }

    public static class CookoBean {
        /**
         * id : 1
         * cookfront : 0
         * dietionfront : 1
         * certificates : 1
         * cookimg : /static/img/cook_img/5b1e1f7b6b6b2.jpg
         * cookname : 小王
         */

        private int id;
        private int cookfront;
        private int dietionfront;
        private int certificates;
        private String cookimg;
        private String cookname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getCertificates() {
            return certificates;
        }

        public void setCertificates(int certificates) {
            this.certificates = certificates;
        }

        public String getCookimg() {
            return cookimg;
        }

        public void setCookimg(String cookimg) {
            this.cookimg = cookimg;
        }

        public String getCookname() {
            return cookname;
        }

        public void setCookname(String cookname) {
            this.cookname = cookname;
        }
    }
}
