package com.example.administrator.jiayan_project.enity.mine;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public class IconBean {
    public IconBean(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private int imageId;

}
