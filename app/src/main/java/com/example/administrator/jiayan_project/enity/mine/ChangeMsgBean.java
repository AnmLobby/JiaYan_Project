package com.example.administrator.jiayan_project.enity.mine;

import java.io.File;

/**
 * Created by Administrator on 2018/7/4/004.
 */

public class ChangeMsgBean  {
  
  

    public ChangeMsgBean(int userid, File file) {
        this.userid = userid;
        this.file = file;
    }
    private int  userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private File file;
}
