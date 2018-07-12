package com.example.administrator.jiayan_project.enity.banquet;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12/012.
 */

public class BanquetComentBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * avatar : /assets/Yii/xz.gif
         * nickname : 啊全
         * createtime : 1531294921
         * content : 四驱按地下室你的拿到家
         * rank : 3
         * img : ["/static/img/dinner_imgs/20180711\\6a00d0f7f9e8cd363aecc425950b3c61.jpg","/static/img/dinner_imgs/20180711\\9c2b893525195cda810dceb2568833d1.jpg","/static/img/dinner_imgs/20180711\\458b752af5b100efb0afb6386db8e92c.jpg"]
         */

        private String avatar;
        private String nickname;
        private int createtime;
        private String content;
        private int rank;
        private List<String> img;

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
