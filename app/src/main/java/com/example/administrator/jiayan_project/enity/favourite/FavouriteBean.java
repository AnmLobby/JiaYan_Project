package com.example.administrator.jiayan_project.enity.favourite;

import java.util.List;

/**
 * Created by Administrator on 2018/6/2/002.
 */

public class FavouriteBean {


    /**
     * code : 200
     * msg : 感谢你的收藏,期待亲的下单
     * data : [{"id":19,"dinnername":"麦肯基","subname":"爱上见不到就开始","price":6889,"originalimg":"/static/img/dinner_img/9c21e2124d244684ec926917b25a897d.jpg"},{"id":13,"dinnername":"阿斯纳税款","subname":"杉德卡是哪所熟悉","price":9999,"originalimg":"/static/img/dinner_img/e32bcd76ea90d1764d017718dcfb7c61.jpg"},{"id":10,"dinnername":"湿哒杰斯的你","subname":"比特币","price":2727,"originalimg":"/static/img/dinner_img/7551e3eaa6dda96e5255dc889724aa412.jpg"},{"id":3,"dinnername":"绿色营养品味美食","subname":"回味年轻的小时候味道哒","price":8888,"originalimg":"/static/img/dinner_img/9c21e2324d244684ec986917b25a8219d.jpg"},{"id":17,"dinnername":"奥斯丁","subname":"乐凯新材","price":6889,"originalimg":"/static/img/dinner_img/9c21e2124d244684ec926917b25a897d.jpg"},{"id":2,"dinnername":"豪华套餐","subname":"触发霸气","price":9998,"originalimg":"/static/img/dinner_img/9c21e2324d244684ec986917b25a829d.jpg"},{"id":18,"dinnername":"麻痹","subname":"男人高大上","price":6666,"originalimg":"/static/img/dinner_img/9c21e2124d244684ec926917b25a897d.jpg"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 19
         * dinnername : 麦肯基
         * subname : 爱上见不到就开始
         * price : 6889
         * originalimg : /static/img/dinner_img/9c21e2124d244684ec926917b25a897d.jpg
         */

        private int id;
        private String dinnername;
        private String subname;
        private int price;
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

        public String getSubname() {
            return subname;
        }

        public void setSubname(String subname) {
            this.subname = subname;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }
    }
}
