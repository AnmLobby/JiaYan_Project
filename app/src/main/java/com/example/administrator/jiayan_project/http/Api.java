package com.example.administrator.jiayan_project.http;

import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FistChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 鱼握拳 on 2018/3/31.
 */

public interface Api {
    /**
     * 主页
     */
    /**首页轮播图*/
    @GET("")
    Observable<BannerBean> getBanner();
    /**超值首选*/
    Observable<FestivalBean> getFirst();
    /**新品推荐*/
    @GET("")
    Observable<RecommendBean> getRecommend();
    /*** 明星推荐*/
    @GET("")
    Observable<StarBean>   getStar();
    /**热门产品*/
    @GET("")
    Observable<HotBean> getHot();
    /***节日盛宴*/
    @GET("")
    Observable<FestivalBean>    getFestival();

}
