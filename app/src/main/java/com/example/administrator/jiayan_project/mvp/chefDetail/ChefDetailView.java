package com.example.administrator.jiayan_project.mvp.chefDetail;

import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public interface ChefDetailView  extends IMvpBaseView {
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
     * banner 轮播图
     */
    void resultChefBannerSuccess(ChefDetailBannerBean chefDetailBannerBean);

    /**
     * 厨师信息
     */
    void resultChefMsgSuccess(ChefDetailMsgBean  chefDetailMsgBean);

    /**
     * 厨师评价信息
     */
    void resultChefCommentSuccess(ChefDetailCommentBean chefDetailCommentBean);
}
