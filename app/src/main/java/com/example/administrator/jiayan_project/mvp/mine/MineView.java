package com.example.administrator.jiayan_project.mvp.mine;

import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6/006.
 */

public interface MineView extends IMvpBaseView {
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
     * 获取个人信息
     */
    void  resultLoginSuccess(List<LoginBean> loginBean);
}
