package com.example.administrator.jiayan_project.enity.classify;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29/029.
 */

public class ClassifyBean {


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
         * typename : 公司庆典
         * detail : [{"id":1,"dinnername":"鸿门宴","categoryid":1,"originalimg":"/static/img/dinner_img/1c32385f012ab97b02f8a91ee7d3fddd.jpg"},{"id":7,"dinnername":"端风格鸡","categoryid":1,"originalimg":"/static/img/dinner_img/575bcd2f67486c17269b9d8440f30be3.jpg"},{"id":11,"dinnername":"美杜莎的","categoryid":1,"originalimg":"/static/img/dinner_img/aef90ffb9e8e9c4dbde4a65f38939326.jpg"},{"id":13,"dinnername":"阿斯纳税款","categoryid":1,"originalimg":"/static/img/dinner_img/e32bcd76ea90d1764d017718dcfb7c61.jpg"},{"id":35,"dinnername":"萨德艾克","categoryid":1,"originalimg":"/static/img/dinner_img/5b35fdb7d144a.jpg"},{"id":36,"dinnername":"鼎折覆餗都符","categoryid":1,"originalimg":"/static/img/dinner_img/5b35fe3815294.jpg"}]
         */

        private int id;
        private String typename;
        private List<DetailBean> detail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
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
             * dinnername : 鸿门宴
             * categoryid : 1
             * originalimg : /static/img/dinner_img/1c32385f012ab97b02f8a91ee7d3fddd.jpg
             */

            private int id;
            private String dinnername;
            private int categoryid;
            private String originalimg;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDinnername() {
                return dinnername;
            }

            public void setDinnername(String dinnername) {
                this.dinnername = dinnername;
            }

            public int getCategoryid() {
                return categoryid;
            }

            public void setCategoryid(int categoryid) {
                this.categoryid = categoryid;
            }

            public String getOriginalimg() {
                return originalimg;
            }

            public void setOriginalimg(String originalimg) {
                this.originalimg = originalimg;
            }
        }
    }
}
