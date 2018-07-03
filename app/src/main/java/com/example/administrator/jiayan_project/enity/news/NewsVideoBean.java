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
         * id : 11
         * newstitle : 2018中国国际食品餐饮博览会新闻发布会在京召开
         * newsauthor : 晏万家餐饮
         * click : 44
         * newsimg : /uploads/5b39c429f2332.jpg
         */

        private int id;
        private String newstitle;
        private String newsauthor;
        private int click;
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

        public String getNewsimg() {
            return newsimg;
        }

        public void setNewsimg(String newsimg) {
            this.newsimg = newsimg;
        }
    }
}
