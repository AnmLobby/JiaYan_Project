package com.example.administrator.jiayan_project.mvp.cook_regesigt;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.chef.CookRegesigtBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public interface CookRegisterView extends IMvpBaseView {
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
     * chef选择
     */
    void resultRegisterSuccess(FavoritrResultBean favoritrResultBean);

}
