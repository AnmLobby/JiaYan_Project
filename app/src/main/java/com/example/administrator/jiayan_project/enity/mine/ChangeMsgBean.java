package com.example.administrator.jiayan_project.enity.mine;

import java.io.File;

/**
 * Created by Administrator on 2018/7/4/004.
 */

public class ChangeMsgBean  {

    private int  userid;
    private String nickname;
    private String realname;

    public ChangeMsgBean(int userid, String nickname, String realname) {
        this.userid = userid;
        this.nickname = nickname;
        this.realname = realname;
    }







    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }






}
