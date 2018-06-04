package com.example.administrator.jiayan_project.enity.big;

import java.util.List;

/**
 * Created by Administrator on 2018/6/2/002.
 */

public class BigYanBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * dinnername : 绿色营养品味美食
         * originalimg : /static/img/dinner_img/9c21e2324d244684ec986917b25a8219d.jpg
         * price : 8888
         * originprice : 9999
         * salesum : 12312
         */

        private int id;
        private String dinnername;
        private String originalimg;
        private int price;
        private int originprice;
        private int salesum;

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

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getOriginprice() {
            return originprice;
        }

        public void setOriginprice(int originprice) {
            this.originprice = originprice;
        }

        public int getSalesum() {
            return salesum;
        }

        public void setSalesum(int salesum) {
            this.salesum = salesum;
        }
    }
}
