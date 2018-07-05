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
         * id : 1
         * comment : <p><img src="/ueditor/php/upload/image/20180705/1530754976274097.jpg" title="1530754976274097.jpg"/></p><p><img src="/ueditor/php/upload/image/20180705/1530754977688798.jpg" title="1530754977688798.jpg"/></p><p><img src="/ueditor/php/upload/image/20180705/1530754989123284.jpg" title="1530754989123284.jpg"/></p><p><img src="/ueditor/php/upload/image/20180705/1530754989222754.jpg" title="1530754989222754.jpg"/></p><p><img src="/ueditor/php/upload/image/20180705/1530754991111998.jpg" title="1530754991111998.jpg"/></p><p><br/></p>
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
