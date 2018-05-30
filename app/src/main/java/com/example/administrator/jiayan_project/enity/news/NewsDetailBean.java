package com.example.administrator.jiayan_project.enity.news;

import java.util.List;

/**
 * Created by Administrator on 2018/5/7/007.
 */

public class NewsDetailBean {


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
         * newstitle : 我是宴快报哈哈
         * newscontent : 老看手机飞洒地方了
         * newsauthor : 王尼玛
         * click : 100
         * createtime : 1525770675
         * newsimg : /uploads/banner3.png
         */

        private int id;
        private String newstitle;
        private String newscontent;
        private String newsauthor;
        private int click;
        private int createtime;
        private String newsimg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNewstitle() {
            return newstitle;
        }

        public void setNewstitle(String newstitle) {
            this.newstitle = newstitle;
        }

        public String getNewscontent() {
            return newscontent;
        }

        public void setNewscontent(String newscontent) {
            this.newscontent = newscontent;
        }

        public String getNewsauthor() {
            return newsauthor;
        }

        public void setNewsauthor(String newsauthor) {
            this.newsauthor = newsauthor;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public String getNewsimg() {
            return newsimg;
        }

        public void setNewsimg(String newsimg) {
            this.newsimg = newsimg;
        }
    }
}
