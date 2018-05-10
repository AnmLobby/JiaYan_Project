package com.example.administrator.jiayan_project.mvp.homepage;

import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9/009.
 */

public interface FirCallback<T> {
    /**
     * @descriptoin	请求异常
     */
    void requestError(Throwable throwable);
    void requestFirsrSuccess(List<FirstChooseBean> callBack);
}
