package com.example.administrator.jiayan_project.enity.mine;

import java.util.List;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public class MyCommentBean {


    private List<DinnercommentBean> dinnercomment;

    public List<DinnercommentBean> getDinnercomment() {
        return dinnercomment;
    }

    public void setDinnercomment(List<DinnercommentBean> dinnercomment) {
        this.dinnercomment = dinnercomment;
    }

    public static class DinnercommentBean {
        /**
         * id : 2
         * dinnername : 豪华套餐
         * originalimg : /static/img/dinner_img/9c21e2324d244684ec986917b25a829d.jpg
         * price : 888
         * avatar : /assets/Yii/5b471f77e7348.png
         * nickname : 啊全
         * createtime : 1531294921
         * content : 四驱按地下室你的拿到家
         * img : ["/static/img/dinner_imgs/5b1dd3cd6b52e.jpg","/static/img/dinner_imgs/5b1dd3cd6bcd0.jpg","/static/img/dinner_imgs/5b1dd3cd6c33f.jpg"]
         * rank : 3
         */

        private int id;
        private String dinnername;
        private String originalimg;
        private int price;
        private String avatar;
        private String nickname;
        private int createtime;
        private String content;
        private int rank;
        private List<String> img;

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

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public List<String> getImg() {
            return img;
        }

        public void setImg(List<String> img) {
            this.img = img;
        }
    }
}
