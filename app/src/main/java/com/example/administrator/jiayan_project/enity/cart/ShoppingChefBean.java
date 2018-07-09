package com.example.administrator.jiayan_project.enity.cart;

import java.util.List;

/**
 * Created by Administrator on 2018/7/7/007.
 */

public class ShoppingChefBean {

    /**
     * code : 200
     * msg : 感谢你添加购物车,期待亲的下单
     * data : [{"id":37,"cookerid":5,"userid":5,"serve":1,"cookname":"小符","cuisine":"重庆菜系","cookimg":"/static/img/cook_img/5b21d68e67071.jpg","price":666,"banprice":66666,"nianprice":666666},{"id":38,"cookerid":6,"userid":5,"serve":2,"cookname":"小叫","cuisine":"广东菜系","cookimg":"/static/img/cook_img/5b21d6dd93828.jpg","price":666,"banprice":66666,"nianprice":666666}]
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
         * id : 37
         * cookerid : 5
         * userid : 5
         * serve : 1
         * cookname : 小符
         * cuisine : 重庆菜系
         * cookimg : /static/img/cook_img/5b21d68e67071.jpg
         * price : 666
         * banprice : 66666
         * nianprice : 666666
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
    }
}
