package com.example.administrator.jiayan_project.mvp.banquetDetail;

import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetDetailBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/27/027.
 */

public interface BanquetDetailView extends IMvpBaseView {
    /**
     * 加载数据前
     */
    void requestLoading();

    /**
     * 加载出错
     *
     * @param result
     */
    void resultFailure(String result);

    /**
     * 宴会详情
     */
    void resultBanquetDetailSuccess(BanquetDetailBean banquetDetailBean);

}
