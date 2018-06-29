package com.example.administrator.jiayan_project.mvp.classify;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/29/029.
 * 分类列表。底部第二个
 */

public interface MainClassifyView extends IMvpBaseView {
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
     * 分类
     */
    void resultRegisterSuccess(ClassifyBean classifyBean);

}
