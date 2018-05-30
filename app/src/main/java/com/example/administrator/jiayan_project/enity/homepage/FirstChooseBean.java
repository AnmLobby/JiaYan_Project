package com.example.administrator.jiayan_project.enity.homepage;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public class FirstChooseBean {


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
         * originalimg : /static/img/dinner_img/1c32385f012ab97b02f8a91ee7d3fddd.jpg
         * dinnername : 鸿门宴
         * subname : 项羽鸿门设宴
         * price : 999
         */

        private int id;
        private String originalimg;
        private String dinnername;
        private String subname;
        private int price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
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
    }
}
