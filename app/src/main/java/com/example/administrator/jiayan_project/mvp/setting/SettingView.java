package com.example.administrator.jiayan_project.mvp.setting;

import com.example.administrator.jiayan_project.enity.mine.UpdateAppInfo;
import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/25/025.
 */

public interface SettingView extends IMvpBaseView {
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
     * 更新成功
     */
    void resultUpdateSuccess(UpdateAppInfo updateAppInfo);
}