package com.example.administrator.jiayan_project.enity.favourite;

import java.util.List;

/**
 * Created by Administrator on 2018/6/2/002.
 */

public class FavouriteBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 12
         * dinnername : 酸酸甜甜年轻的味道
         * subname : 阿斯顿内存卡了
         * price : 47878
         * originalimg : /static/img/dinner_img/aef90ffb9e8e9c4dbde4a65f38939389.jpg
         */

        private int id;
        private String dinnername;
        private String subname;
        private int price;
        private String originalimg;

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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }
    }
}
