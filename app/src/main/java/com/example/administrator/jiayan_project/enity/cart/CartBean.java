package com.example.administrator.jiayan_project.enity.cart;

import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/16/016.
 */

public class CartBean {
    /**
     * 没用到
     */
    private List<FirstChooseBean.DataBean> data;

    public List<FirstChooseBean.DataBean> getData() {
        return data;
    }

    public void setData(List<FirstChooseBean.DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * originalimg : 2.png
         * dinnername : 万众服务
         * subname : 超值活动
         * price : 8888.00
         */

        private int id;
        private String originalimg;
        private String dinnername;
        private String subname;
        private String price;

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
