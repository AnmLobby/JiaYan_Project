package com.example.administrator.jiayan_project.enity.banquet;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public class BanquetBean {


    private List<DataBean> data;
    private List<SizeBean> size;
    private List<String> img;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<SizeBean> getSize() {
        return size;
    }

    public void setSize(List<SizeBean> size) {
        this.size = size;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }

    public static class DataBean {
        /**
         * id : 8
         * dinnername : 豆腐干耦合
         * subname : 傲霜斗雪
         * originprice : 66600
         * price : 9755
         * salesum : 6567
         * storecount : 666
         * unit : 1
         * state : 1
         * comment : 煮米饭
         将水煮开沸腾后，将洗干净的米倒入水中过滤捞出，记住，一下下就可以了。然后，将米放在炉子上蒸熟。
         隔夜饭水分比较少，炒出来的饭就颗粒松散，比较有嚼头，这个常识大多数人都知道了。不过如果没有隔夜饭，也有一个办法。将煮好的米饭摊凉，用保鲜膜包好，放入急冻柜里冷冻半个小时左右后取出，以饭粒的水分被冷干，但又没有结冰为宜，如果结冰了就不能用。这时可以看到饭粒是干爽饱满的，炒起来就不会因为水分太多而粘锅或太湿。
         鸡蛋
         如果蛋炒饭是蛋饭分开，或者有蛋丝的，都不符合要求。只有鸡蛋充分裹在每粒饭上，完全看不见鸡蛋的影子，才算是成功。
         而要成功，第一要素就是保证蛋液不能接触到锅底。因此，在炒的时候，蛋液要慢慢地淋在饭粒上，让饭粒充分吸收后翻炒，这样鸡蛋就不会接触到锅底了。不过，要学会这一技术，还得靠反复的练习才行。
         炒饭
         炒饭前饭内加少许素油拌匀，让饭粒分开，再倒入一半蛋液拌匀浸泡20分钟；旺火油锅下拌好油和蛋液的米饭，迅速炒匀炒干，使鸡蛋包住每粒米饭，行话叫“金包银”。然后下熟青豆及跑马蛋，加盐、葱花，翻炒片刻后出锅。
         有的人在炒饭的过程中，会出现粘锅、炒糊的现象，这是锅底不够热的缘故。要热好锅底，首先舀一勺油热锅，待油稍微沸腾时，将多余的油倒出，给锅降温。这时的温度，就最适宜下锅。如果家里用电磁炉的话，将温度控制在180℃即可。
         将油倒出这个步骤的意义，除了给锅降温之外，还有另一个意义，就是将锅里的渣质倒出，以免影响炒饭的口感
         * originalimg : /static/img/dinner_img/7551e3eaa6dda96e5255dc889724aa41.jpg
         * guige : 6
         * cookerid : 1
         * score : 66
         * categoryid : 2
         * sort : 0
         * huishou : 1
         * time : 1526289721
         * label : 3
         * bigtype : 2
         * edittime : null
         * dinggou : 最大的能接2000桌，最少1桌起订(酒席宴席类)。
         * fuwu : 宴万家为每一位通过平台下单的顾客朋友购买团体保险，保障服务的食品安全、消防安全、人身安全。
         * tuikuan : 家宴在线支付及POS机刷卡支付订单退款，如涉及到银行信息家宴会依据银行及相关机构已经建立的条例处理退款，为了保证客户账户金额的安全，我们均会安排原卡原退。
         */

        private int id;
        private String dinnername;
        private String subname;
        private int originprice;
        private int price;
        private int salesum;
        private int storecount;
        private int unit;
        private int state;
        private String comment;
        private String originalimg;
        private int guige;
        private int cookerid;
        private int score;
        private int categoryid;
        private int sort;
        private int huishou;
        private int time;
        private int label;
        private int bigtype;
        private Object edittime;
        private String dinggou;
        private String fuwu;
        private String tuikuan;

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

        public int getOriginprice() {
            return originprice;
        }

        public void setOriginprice(int originprice) {
            this.originprice = originprice;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSalesum() {
            return salesum;
        }

        public void setSalesum(int salesum) {
            this.salesum = salesum;
        }

        public int getStorecount() {
            return storecount;
        }

        public void setStorecount(int storecount) {
            this.storecount = storecount;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getOriginalimg() {
            return originalimg;
        }

        public void setOriginalimg(String originalimg) {
            this.originalimg = originalimg;
        }

        public int getGuige() {
            return guige;
        }

        public void setGuige(int guige) {
            this.guige = guige;
        }

        public int getCookerid() {
            return cookerid;
        }

        public void setCookerid(int cookerid) {
            this.cookerid = cookerid;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(int categoryid) {
            this.categoryid = categoryid;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getHuishou() {
            return huishou;
        }

        public void setHuishou(int huishou) {
            this.huishou = huishou;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public int getBigtype() {
            return bigtype;
        }

        public void setBigtype(int bigtype) {
            this.bigtype = bigtype;
        }

        public Object getEdittime() {
            return edittime;
        }

        public void setEdittime(Object edittime) {
            this.edittime = edittime;
        }

        public String getDinggou() {
            return dinggou;
        }

        public void setDinggou(String dinggou) {
            this.dinggou = dinggou;
        }

        public String getFuwu() {
            return fuwu;
        }

        public void setFuwu(String fuwu) {
            this.fuwu = fuwu;
        }

        public String getTuikuan() {
            return tuikuan;
        }

        public void setTuikuan(String tuikuan) {
            this.tuikuan = tuikuan;
        }
    }

    public static class SizeBean {
        /**
         * id : 1
         * sname : 普通紫色
         * price : 0
         */

        private int id;
        private String sname;
        private int price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
