package com.example.administrator.jiayan_project.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/5/30/030.
 */
@Entity
public class KeepUserBean {
    @Id(autoincrement = true)
    public Long id;
//    private int id;
    private int group_id;
    private String username;
    private String nickname;
    private String realname;
    private int age;
    private String mobile;
    private String avatar;
    private int level;
    private int gender;
    private int userId;
    @Generated(hash = 1761458948)
    public KeepUserBean(Long id, int group_id, String username, String nickname,
            String realname, int age, String mobile, String avatar, int level,
            int gender, int userId) {
        this.id = id;
        this.group_id = group_id;
        this.username = username;
        this.nickname = nickname;
        this.realname = realname;
        this.age = age;
        this.mobile = mobile;
        this.avatar = avatar;
        this.level = level;
        this.gender = gender;
        this.userId = userId;
    }
    @Generated(hash = 1345894309)
    public KeepUserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getGroup_id() {
        return this.group_id;
    }
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getRealname() {
        return this.realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
