package com.example.administrator.jiayan_project.mvp.base;

import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.enity.login.LoginBean;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/6.
 */

public interface IBaseListCallBack<T> {
    /**
     * @descriptoin	请求异常
     */
    void requestError(Throwable throwable);

    /**
     * @descriptoin	请求成功
     * @param
     */
    void requestBannerSuccess(List<LoginBean> callBack);










}

