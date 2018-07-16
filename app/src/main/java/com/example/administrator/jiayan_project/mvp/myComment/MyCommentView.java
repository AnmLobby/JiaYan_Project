package com.example.administrator.jiayan_project.mvp.myComment;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.mine.MyChefCommentBean;
import com.example.administrator.jiayan_project.enity.mine.MyCommentBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public interface MyCommentView  extends IMvpBaseView {
    /**
     * 加载数据前
     */
    void requestLoading();

    /**
     * 加载出错
     * @param result
     */
    void resultFailure(String result);


    void  resultMyCommentSuccess(MyCommentBean myCommentBean);

    void resultMyChefCommentSuccess(MyChefCommentBean myChefCommentBean);
}
