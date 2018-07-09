package com.example.administrator.jiayan_project.enity.classify;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9/009.
 */

public class MainChefClassifyBean {

    private List<TypedataBean> typedata;

    public List<TypedataBean> getTypedata() {
        return typedata;
    }

    public void setTypedata(List<TypedataBean> typedata) {
        this.typedata = typedata;
    }

    public static class TypedataBean {
        /**
         * id : 1
         * titlename : 中式营养师
         * detail : [{"id":1,"honor_id":1,"cookname":"小王","cookimg":"/static/img/cook_img/5b1e1f7b6b6b2.jpg"},{"id":10,"honor_id":1,"cookname":"爆炒","cookimg":"/static/img/cook_img/5b21d736a852d.jpg"},{"id":16,"honor_id":1,"cookname":"呀呀呀","cookimg":"/static/img/cook_img/5b3f15c397589.jpg"},{"id":53,"honor_id":1,"cookname":"王尼玛","cookimg":"/static/img/cook_img/5b3c37afdcca0.jpg"},{"id":54,"honor_id":1,"cookname":"王尼玛","cookimg":"/static/img/cook_img/5b3c35217f19a.png"}]
         */

        private int id;
        private String titlename;
        private List<DetailBean> detail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitlename() {
            return titlename;
        }

        public void setTitlename(String titlename) {
            this.titlename = titlename;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * id : 1
             * honor_id : 1
             * cookname : 小王
             * cookimg : /static/img/cook_img/5b1e1f7b6b6b2.jpg
             */

            private int id;
            private int honor_id;
            private String cookname;
            private String cookimg;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getHonor_id() {
                return honor_id;
            }

            public void setHonor_id(int honor_id) {
                this.honor_id = honor_id;
            }

            public String getCookname() {
                return cookname;
            }

            public void setCookname(String cookname) {
                this.cookname = cookname;
            }

            public String getCookimg() {
                return cookimg;
            }

            public void setCookimg(String cookimg) {
                this.cookimg = cookimg;
            }
        }
    }
}
