package com.example.administrator.jiayan_project.enity.homepage;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public class BannerBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * pid : 1
         * mediatype : 0
         * adname : 首页banner轮播2
         * adlink : /uploads/banner2.jpg
         * adcode : 2.jpg
         * starttime : 1443542400
         * endtime : 1601481600
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
