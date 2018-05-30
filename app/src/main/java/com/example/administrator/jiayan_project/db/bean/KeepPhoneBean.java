package com.example.administrator.jiayan_project.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/5/30/030.
 */
@Entity
public class KeepPhoneBean {
    @Id(autoincrement = true)
    public Long id;
    public String phoneNumber;
    @Generated(hash = 808942148)
    public KeepPhoneBean(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
    @Generated(hash = 328738167)
    public KeepPhoneBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
