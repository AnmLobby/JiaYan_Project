package com.example.administrator.jiayan_project.mvp.news_list;

/**
 * Created by Administrator on 2018/6/1/001.
 */

import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.mvp.base.IBaseView;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * （5个页面）
 * 宴快报新闻链接
 */
public interface NewsListView  extends IMvpBaseView{
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
     * 新闻列表
     */
    void  resultNewsListSuccess(NewsListBean newsListBean);

    /**
     * 新闻视频
     */
    void resultVideoListSuccess(NewsListBean newsVideoBean);
}
