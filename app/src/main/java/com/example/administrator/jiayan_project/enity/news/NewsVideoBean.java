package com.example.administrator.jiayan_project.enity.news;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8/008.
 */

public class NewsVideoBean {

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
         * newstitle : 我是宴快报视频
         * newscontent : 阿斯加德弗兰克健身房
         * newsauthor : 王尼美
         * click : 101
         * createtime : 1525770675
         * newsimg : /uploads/banner3.png
         * newsvideo : http://www.ipta.cn/video.mp4
         */

        private int id;
        private String newstitle;
        private String newscontent;
        private String newsauthor;
        private int click;
        private int createtime;
        private String newsimg;
        private String newsvideo;

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

        public String getNewsvideo() {
            return newsvideo;
        }

        public void setNewsvideo(String newsvideo) {
            this.newsvideo = newsvideo;
        }
    }
}
