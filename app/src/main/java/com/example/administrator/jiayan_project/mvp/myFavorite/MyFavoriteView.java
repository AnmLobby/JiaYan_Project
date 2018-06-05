package com.example.administrator.jiayan_project.mvp.myFavorite;

import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/5/005.
 */

public interface MyFavoriteView extends IMvpBaseView {
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
     * 收藏列表接口
     */
    void  resultMyFavoriteSuccess(FavouriteBean favouriteBean);
}

