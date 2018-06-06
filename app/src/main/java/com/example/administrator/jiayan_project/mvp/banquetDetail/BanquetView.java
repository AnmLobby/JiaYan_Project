package com.example.administrator.jiayan_project.mvp.banquetDetail;

import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.CheckFavoriteBean;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.banquet.KeepFavoriteBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public interface BanquetView extends IMvpBaseView {
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
     * 宴会详情
     */
    void  resultBanquetSuccess(BanquetBean banquetBean);

    /**
     * 添加到我的收藏
     */
    void resultKeepFavoriteSuccess(FavoritrResultBean favoritrResultBean);

    /**
     * 检测是否收藏该宴席
     */
    void resultCheckFavoriteSuccess(CheckFavoriteBean checkFavoriteBean);
}
