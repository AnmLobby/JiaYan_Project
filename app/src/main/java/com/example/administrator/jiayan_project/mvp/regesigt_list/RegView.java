package com.example.administrator.jiayan_project.mvp.regesigt_list;

import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/16/016.
 */

public interface RegView extends IMvpBaseView {
    /**
     * 加载数据前
     */
    void requestLoading();

    /**
     * 加载出错
     * @param result
     */
    void resultFailure(String result);

    /**
     * 轮播图
     */
    void  resultBannerSuccess(RegListBean regListBean);

}
