package com.example.administrator.jiayan_project.mvp.homepage;

import com.example.administrator.jiayan_project.enity.homepage.HotBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9/009.
 */

public interface HotCallback<T> {
    /**
     * @descriptoin	请求异常
     */
    void requestError(Throwable throwable);
    void requestHotSuccess(List<HotBean> callBack);
}
