package com.example.administrator.jiayan_project.enity.reception;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionDinnerBean {


    private List<ReceptionBean> reception;
    private List<CookoBean> cooko;
    private List<AdBean> ad;

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

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public static class ReceptionBean {
        /**
         * id : 17
         * price : 6889
         * dinnername : 奥斯丁鸡
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
         *  pinfen: 3
         */

        private int id;
        private int cookfront;
        private int dietionfront;
        private int certificates;
        private String cookimg;
        private String cookname;

        public int getPinfen() {
            return pinfen;
        }

        public void setPinfen(int pinfen) {
            this.pinfen = pinfen;
        }

        private int pinfen;
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

    public static class AdBean {
        /**
         * id : 4
         * pid : 1
         * mediatype : 0
         * adname : 首页banner轮播4
         * adlink : https://www.baidu.com/
         * adcode : /uploads/banner2.png
         * starttime : 1441123200
         * endtime : 1731513600
         * linkman :
         * linkemail :
         * linkphone :
         * clickcount : 0
         * enabled : 1
         * orderby : 50
         * target : 0
         */

        private int id;
        private int pid;
        private int mediatype;
        private String adname;
        private String adlink;
        private String adcode;
        private int starttime;
        private int endtime;
        private String linkman;
        private String linkemail;
        private String linkphone;
        private int clickcount;
        private int enabled;
        private int orderby;
        private int target;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getMediatype() {
            return mediatype;
        }

        public void setMediatype(int mediatype) {
            this.mediatype = mediatype;
        }

        public String getAdname() {
            return adname;
        }

        public void setAdname(String adname) {
            this.adname = adname;
        }

        public String getAdlink() {
            return adlink;
        }

        public void setAdlink(String adlink) {
            this.adlink = adlink;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public int getStarttime() {
            return starttime;
        }

        public void setStarttime(int starttime) {
            this.starttime = starttime;
        }

        public int getEndtime() {
            return endtime;
        }

        public void setEndtime(int endtime) {
            this.endtime = endtime;
        }

        public String getLinkman() {
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getLinkemail() {
            return linkemail;
        }

        public void setLinkemail(String linkemail) {
            this.linkemail = linkemail;
        }

        public String getLinkphone() {
            return linkphone;
        }

        public void setLinkphone(String linkphone) {
            this.linkphone = linkphone;
        }

        public int getClickcount() {
            return clickcount;
        }

        public void setClickcount(int clickcount) {
            this.clickcount = clickcount;
        }

        public int getEnabled() {
            return enabled;
        }

        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }

        public int getOrderby() {
            return orderby;
        }

        public void setOrderby(int orderby) {
            this.orderby = orderby;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }
    }
}
