package com.example.administrator.jiayan_project.mvp.reception;

import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * 高端接待
 * Created by Administrator on 2018/6/15/015.
 */

public interface ReceptionView extends IMvpBaseView {
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
    void  resultBannerSuccess(ReceptionBannerBean receptionBannerBean);

    /**
     *      * 厨师详情信息
    */
    void  resultChefSuccess(ReceptionChefBean receptionChefBean);

    /**
     * 高端宴席信息
     */

    void  resultDinnerSuccess(ReceptionDinnerBean receptionDinnerBean);


}
