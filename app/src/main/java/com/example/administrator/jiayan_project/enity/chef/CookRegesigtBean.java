package com.example.administrator.jiayan_project.enity.chef;

/**
 * Created by Administrator on 2018/6/14/014.
 */

/**
 * 注册厨师body
 */
public class CookRegesigtBean {
    private String  id;
    private String name;
    private String age ;
    private String sex;
    private String address;
    private String mobile;
    private String cookage;

    public CookRegesigtBean(String id, String name, String age, String sex, String address, String mobile, String cookage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.mobile = mobile;
        this.cookage = cookage;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCookage() {
        return cookage;
    }

    public void setCookage(String cookage) {
        this.cookage = cookage;
    }



}
