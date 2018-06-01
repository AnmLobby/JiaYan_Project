package com.example.administrator.jiayan_project.utils.eventbus;

/**
 * Created by Administrator on 2018/5/31/031.
 */

public class StartNewsEvent {
//    public StartNewsEvent(String message){
//        this.message=message;
//    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
