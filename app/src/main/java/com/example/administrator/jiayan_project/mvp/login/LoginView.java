package com.example.administrator.jiayan_project.mvp.login;


import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by 鱼握拳 on 2018/4/27.
 */

public interface LoginView extends IMvpBaseView {
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
     * 登陆接口
     */
    void  resultUserSuccess(UserBean userBean);
}
