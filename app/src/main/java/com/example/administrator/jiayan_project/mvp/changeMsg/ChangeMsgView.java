package com.example.administrator.jiayan_project.mvp.changeMsg;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/7/4/004.
 */

public interface ChangeMsgView  extends IMvpBaseView {

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
     * 上传成功
     */
    void  resultPostSuccess(FavoritrResultBean favoritrResultBean);
}
