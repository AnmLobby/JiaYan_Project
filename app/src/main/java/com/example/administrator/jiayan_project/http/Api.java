package com.example.administrator.jiayan_project.http;

import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 鱼握拳 on 2018/3/31.
 */

public interface Api {
    /**
     * 主页
     */
    /**首页轮播图*/
    @GET("index.php/api/index/ad")
    Observable<BannerBean> getBanner();

    /**
     * 快报
     */
    @GET("index.php/api/index/news")
    Observable<NewsBean> getNews();

    /**超值首选*/
    @GET("index.php/api/index/huasuan")
    Observable<FirstChooseBean> getFirst();

    /**新品推荐*/
    @GET("index.php/api/index/isnew")
    Observable<RecommendBean> getRecommend();

    /*** 明星推荐*/
    @GET("index.php/api/index/feature")
    Observable<StarBean>   getStar();

    /**热门产品*/
    @GET("index.php/api/index/ishot")
    Observable<HotBean> getHot();

    /***节日盛宴*/
    @GET("index.php/api/index/isfeast")
    Observable<FestivalBean>    getFestival();

    /**
     * 登陆
     * @return
     */
    @POST("")
    Observable<UserBean>  postUser();



}
