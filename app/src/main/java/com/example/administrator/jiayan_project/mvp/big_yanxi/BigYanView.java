package com.example.administrator.jiayan_project.mvp.big_yanxi;

import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/2/002.
 */

public interface BigYanView extends IMvpBaseView {
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
     * 宴席列表
     */
    void  resultYanListSuccess(BigYanBean newsListBean);


}
