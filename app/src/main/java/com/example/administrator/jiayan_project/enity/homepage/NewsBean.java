package com.example.administrator.jiayan_project.enity.homepage;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10/010.
 */

public class NewsBean {

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
         */

        private int id;
        private String newstitle;

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
    }
}
