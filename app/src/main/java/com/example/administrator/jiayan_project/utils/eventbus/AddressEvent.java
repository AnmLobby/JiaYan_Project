package com.example.administrator.jiayan_project.utils.eventbus;

import com.example.administrator.jiayan_project.db.bean.AddressBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/7/007.
 */

public class AddressEvent implements Serializable{
    public Long id;
    public String username;
    public String realname;

    public AddressEvent(Long id, String realname, String phone, String area, String address, boolean isdefault) {
        this.id = id;
        this.realname = realname;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.isdefault = isdefault;
    }

    public String phone;
    public String area;
    public String street;
    public String address;
    public boolean isdefault;




    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsdefault() {
        return isdefault;
    }

    public void setIsdefault(boolean isdefault) {
        this.isdefault = isdefault;
    }



}
