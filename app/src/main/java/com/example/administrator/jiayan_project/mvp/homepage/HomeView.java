package com.example.administrator.jiayan_project.mvp.homepage;

import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public interface HomeView extends IMvpBaseView {
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
     * 加载轮播图
     * @param
     */
    void    successBanner(BannerBean bannerBean);

    /**
     * 超值首选
     * @param firstChooseBean
     */
    void    successFirst(FirstChooseBean firstChooseBean);

    /**
     * 新品推荐
     * @param recommendBean
     */
    void    successRecommend(RecommendBean recommendBean);

    /**
     * 明星推荐
     * @param starBean
     */
    void    successStar(StarBean starBean);

    /**
     * 热门产品
     * @param hotBean
     */
    void    successHot(HotBean hotBean);

    /**
     * 节日盛宴
     * @param festivalBean
     */
    void    successFestival(FestivalBean festivalBean);

    /**
     * 快报
     * @param newsBean
     */
    void    successNews(NewsBean newsBean);
}
