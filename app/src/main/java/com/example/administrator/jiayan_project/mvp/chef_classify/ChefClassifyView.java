package com.example.administrator.jiayan_project.mvp.chef_classify;

import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.mvp.base.IBaseView;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public interface ChefClassifyView extends IMvpBaseView {
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
    void resultChefClassifySuccess(ChefClassifyBean chefClassifyBean);

}
