package com.example.administrator.jiayan_project.mvp.jifen;

import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/7/10/010.
 */

public interface JifenView extends IMvpBaseView {
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

    void resultSuccess(JifenMainBean jifenMainBean);
}
