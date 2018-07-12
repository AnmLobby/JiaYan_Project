package com.example.administrator.jiayan_project.enity.cart;

import java.util.List;

/**
 * Created by Administrator on 2018/7/7/007.
 */

public class ShoppingChefBean {

    /**
     * code : 200
     * msg : 感谢你添加购物车,期待亲的下单
     * data : [{"id":49,"cookerid":5,"userid":5,"serve":1,"cookname":"小符","cuisine":"重庆菜系","cookimg":"/static/img/cook_img/5b21d68e67071.jpg","price":666,"banprice":66666,"nianprice":666666,"cookerimg":"/assets/cook/5b20dce58ea95.png","titlename":"中式烹调师"}]
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
         * id : 49
         * cookerid : 5
         * userid : 5
         * serve : 1
         * cookname : 小符
         * cuisine : 重庆菜系
         * cookimg : /static/img/cook_img/5b21d68e67071.jpg
         * price : 666
         * banprice : 66666
         * nianprice : 666666
         * cookerimg : /assets/cook/5b20dce58ea95.png
         * titlename : 中式烹调师
         */
        public boolean isChoosed;
        private int id;
        private int cookerid;
        private int userid;
        private int serve;
        private String cookname;
        private String cuisine;
        private String cookimg;
        private int price;
        private int banprice;
        private int nianprice;
        private String cookerimg;
        private String titlename;
        public boolean isChoosed() {
            return isChoosed;
        }

        public void setChoosed(boolean choosed) {
            isChoosed = choosed;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCookerid() {
            return cookerid;
        }

        public void setCookerid(int cookerid) {
            this.cookerid = cookerid;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getServe() {
            return serve;
        }

        public void setServe(int serve) {
            this.serve = serve;
        }

        public String getCookname() {
            return cookname;
        }

        public void setCookname(String cookname) {
            this.cookname = cookname;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public String getCookimg() {
            return cookimg;
        }

        public void setCookimg(String cookimg) {
            this.cookimg = cookimg;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
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

        public String getCookerimg() {
            return cookerimg;
        }

        public void setCookerimg(String cookerimg) {
            this.cookerimg = cookerimg;
        }

        public String getTitlename() {
            return titlename;
        }

        public void setTitlename(String titlename) {
            this.titlename = titlename;
        }
    }
}
