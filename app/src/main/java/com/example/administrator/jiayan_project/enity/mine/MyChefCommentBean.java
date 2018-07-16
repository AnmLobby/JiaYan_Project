package com.example.administrator.jiayan_project.enity.mine;

import java.util.List;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public class MyChefCommentBean {

    private List<CookercommentBean> cookercomment;

    public List<CookercommentBean> getCookercomment() {
        return cookercomment;
    }

    public void setCookercomment(List<CookercommentBean> cookercomment) {
        this.cookercomment = cookercomment;
    }

    public static class CookercommentBean {
        /**
         * id : 1
         * cookname : 小王
         * cookimg : /static/img/cook_img/5b1e1f7b6b6b2.jpg
         * price : 888
         * avatar : /assets/Yii/5b456e2ab9947.jpg
         * nickname : 王尼玛
         * createtime : 1526523654
         * img : ["/static/img/dinner_imgs/5b1dd3cd6b52e.jpg","/static/img/dinner_imgs/5b1dd3cd6bcd0.jpg","/static/img/dinner_imgs/5b1dd3cd6c33f.jpg","/static/img/dinner_imgs/5b1dd3cd6bcd0.jpg"]
         * content : 6666
         * rank : 1
         */

        private int id;
        private String cookname;
        private String cookimg;
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
