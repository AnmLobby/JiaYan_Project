package com.example.administrator.jiayan_project.enity.cart;

import java.util.List;

/**
 * Created by Administrator on 2018/5/16/016.
 */

public class CartBean {

    /**
     * code : 200
     * msg : 感谢你添加购物车,期待亲的下单
     * data : [{"sizeid":"4","sname":"普通红色","ren":10,"num":1,"id":1,"dinnername":"鸿门宴","subname":"项羽鸿门设宴","price":999,"originalimg":"/static/img/dinner_img/1c32385f012ab97b02f8a91ee7d3fddd.jpg"},{"sizeid":"1","sname":"普通紫色","ren":10,"num":1,"id":13,"dinnername":"阿斯纳税款","subname":"杉德卡是哪所熟悉","price":9999,"originalimg":"/static/img/dinner_img/e32bcd76ea90d1764d017718dcfb7c61.jpg"},{"sizeid":"1","sname":"普通紫色","ren":255,"num":33333,"id":9,"dinnername":"小时候的味道棒棒棒","subname":"撒答案是","price":999,"originalimg":"/static/img/dinner_img/adc7a8dee661f14d43d3ebef624e8981.jpg"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sizeid : 4
         * sname : 普通红色
         * ren : 10
         * num : 1
         * id : 1
         * dinnername : 鸿门宴
         * subname : 项羽鸿门设宴
         * price : 999
         * originalimg : /static/img/dinner_img/1c32385f012ab97b02f8a91ee7d3fddd.jpg
         */
        public boolean isChoosed;
        private String sizeid;
        private String sname;
        private int ren;
        private int num;
        private int id;
        private String dinnername;
        private String subname;
        private int price;
        private String originalimg;

        public String getDetail() {
            return sizeid;
        }

        public void setDetail(String sizeid) {
            this.sizeid = sizeid;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public int getRen() {
            return ren;
        }

        public void setRen(int ren) {
            this.ren = ren;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

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
        public boolean isChoosed() {
            return isChoosed;
        }

        public void setChoosed(boolean choosed) {
            isChoosed = choosed;
        }

    }
}
