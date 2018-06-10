package com.example.administrator.jiayan_project.enity.banquet;

/**
 * Created by Administrator on 2018/6/9/009.
 */

public class PostAddCartBean {
    private int   userid;
    private int   sizeid;
    private int   num;
    private int  feastid;
    private int  ren;

    public PostAddCartBean(int userid, int sizeid, int num, int feastid, int ren) {
        this.userid = userid;
        this.sizeid = sizeid;
        this.num = num;
        this.feastid = feastid;
        this.ren = ren;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getDetail() {
        return sizeid;
    }

    public void setDetail(int sizeid) {
        this.sizeid = sizeid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getFeastid() {
        return feastid;
    }

    public void setFeastid(int feastid) {
        this.feastid = feastid;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

}
