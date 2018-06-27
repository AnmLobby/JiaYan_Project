package com.example.administrator.jiayan_project.enity.search;

/**
 * Created by Administrator on 2018/6/26/026.
 */

public class SearchBodyBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchBodyBean(String name) {
        this.name = name;
    }

    private String name;
}
