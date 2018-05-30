package com.example.administrator.jiayan_project.http;

import com.example.administrator.jiayan_project.enity.cart.CartBean;
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
import retrofit2.http.Query;

/**
 * Created by 鱼握拳 on 2018/3/31.
 */

public interface Api {
    /**
     * 主页
     */
    /**首页轮播图*/
    @GET("index/ad")
    Observable<BannerBean> getBanner();

    /**
     * 快报
     */
    @GET("index/news")
    Observable<NewsBean> getNews();

    /**超值首选*/
    @GET("index/huasuan")
    Observable<FirstChooseBean> getFirst();

    /**新品推荐*/
    @GET("index/isnew")
    Observable<RecommendBean> getRecommend();

    /*** 明星推荐*/
    @GET("index/feature")
    Observable<StarBean>   getStar();

    /**热门产品*/
    @GET("index/ishot")
    Observable<HotBean> getHot();

    /***节日盛宴*/
    @GET("index/isfeast")
    Observable<FestivalBean>    getFestival();

    /**
     * 登陆
     * @return
     */
//    http://v.juhe.cn/sms/send?mobile=手机号码&tpl_id=短信模板ID&tpl_value=%23code%23%3D654654&key=
    @POST("send")
    Observable<UserBean>  postUser(@Query("mobile") String mobile,
                                   @Query("tpl_value") String tpl_value,
                                    @Query("key") String key,
                                    @Query("tpl_id") String tpl_id);

    /**
    * 购物车
    */
    @GET("index.php/api/index/huasuan")
    Observable<CartBean>   getCart();
}
