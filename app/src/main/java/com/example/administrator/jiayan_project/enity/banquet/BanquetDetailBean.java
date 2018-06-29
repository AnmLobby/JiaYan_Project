package com.example.administrator.jiayan_project.enity.banquet;

import java.util.List;

/**
 * Created by Administrator on 2018/6/27/027.
 */

public class BanquetDetailBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 19
         * comment : <p><img src="/ueditor/php/upload/image/20180627/1530082324.jpg" title="1530082324.jpg"/></p><p><img src="/ueditor/php/upload/image/20180627/1530082324.jpg" title="1530082324.jpg"/></p><p>						</p>
         */

        private int id;
        private String comment;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
