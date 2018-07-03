package com.example.administrator.jiayan_project.enity.homepage;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3/003.
 */

public class MoreYanBean {


    /**
     * data : [{"id":36,"originalimg":"/static/img/dinner_img/5b35fe3815294.jpg","dinnername":"鼎折覆餗都符","subname":"刚开始电动车迪士尼","price":5555,"salesum":0}]
     * code : 200
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 36
         * originalimg : /static/img/dinner_img/5b35fe3815294.jpg
         * dinnername : 鼎折覆餗都符
         * subname : 刚开始电动车迪士尼
         * price : 5555
         * salesum : 0
         */

        private int id;
        private String originalimg;
        private String dinnername;
        private String subname;
        private int price;
        private int salesum;

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

        public int getSalesum() {
            return salesum;
        }

        public void setSalesum(int salesum) {
            this.salesum = salesum;
        }
    }
}
