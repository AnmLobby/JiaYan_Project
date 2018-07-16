package com.example.administrator.jiayan_project.mvp.banquetDetail;

import com.example.administrator.jiayan_project.enity.banquet.BanquetComentBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetNumBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/7/12/012.
 */

public  interface BanquetCommentView extends IMvpBaseView {
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
         * 宴会评价
         */
        void resultBanquetCommentSuccess(BanquetComentBean banquetDetailBean);


        void resultBanquetCommentGoodSuccess(BanquetComentBean banquetDetailBean);


        void resultBanquetCommentMidSuccess(BanquetComentBean banquetDetailBean);


        void resultBanquetCommentChaSuccess(BanquetComentBean banquetDetailBean);


        void resultBanquetCommentNumSuccess(BanquetNumBean banquetNumBean);


        }
