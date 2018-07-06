package com.example.administrator.jiayan_project.mvp.changeMsg;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

import java.util.List;

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
     * 上传头像成功
     */
    void  resultPostSuccess(FavoritrResultBean favoritrResultBean);

    /**
     * 修改个人信息
     */
    void  resultPostMsgSuccess(FavoritrResultBean favoritrResultBean);


//    /**
//     * 获取个人信息
//     */
//    void  resultLoginSuccess(LoginBean loginBean);
}
