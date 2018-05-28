package com.example.administrator.jiayan_project.http;



/**
 * 描述：业务对象的基类
 */
public class BaseModel {
    //retrofit请求数据的管理类
    public RetrofitManager retrofitManager,loginManager;

    public BaseModel() {
        retrofitManager = RetrofitManager.builder(Constants.JiaYan);
        loginManager=RetrofitManager.builder(Constants.JuHe);
    }
}
