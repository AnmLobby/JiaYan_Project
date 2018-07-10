package com.example.administrator.jiayan_project.http;

import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetDetailBean;
import com.example.administrator.jiayan_project.enity.banquet.CheckFavoriteBean;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.banquet.KeepFavoriteBean;
import com.example.administrator.jiayan_project.enity.banquet.PostAddCartBean;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.cart.CartBean;
import com.example.administrator.jiayan_project.enity.cart.ShoppingChefBean;
import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.chef.CookRegesigtBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.enity.classify.MainChefClassifyBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.MoreYanBean;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.enity.mine.ChangeMsgBean;
import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.example.administrator.jiayan_project.enity.mine.UpdateAppInfo;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.enity.search.HotSearchBean;
import com.example.administrator.jiayan_project.enity.search.SearchBodyBean;
import com.example.administrator.jiayan_project.enity.search.SearchResultBean;
import com.example.administrator.jiayan_project.mvp.regesigt_list.RegListBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
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
     * 登陆短信接口
     * @return
     */
//    http://v.juhe.cn/sms/send?mobile=手机号码&tpl_id=短信模板ID&tpl_value=%23code%23%3D654654&key=
    @POST("send")
    Observable<UserBean>  postUser(@Query("mobile") String mobile,
                                   @Query("tpl_value") String tpl_value,
                                    @Query("key") String key,
                                    @Query("tpl_id") String tpl_id);

    /**
     * post到服务器
     * @param username
     * @return
     */
    @GET("Login/login/username/{username}")
    Observable<List<LoginBean>>  postMessage(@Path("username") String username);


//    /**
//     * 获取个人信息
//     * @param username
//     * @return
//     */
//    @GET("Login/login/username/{username}")
//    Observable<LoginBean>  getMineMessage(@Path("username") String username);

    /**
    * 购物车,没有用到，已经取消
    */
    @GET("index.php/api/index/huasuan")
    Observable<CartBean>   getCart();

    /**
     * 快报详情信息
     */
    @GET("News/details/id/{id}")
    Observable<NewsDetailBean>   getNeswDetail(@Path("id") String id);

    /**
     * 新闻列表首页
     */
    @GET("News/news")
    Observable<NewsListBean>   getNeswHome();

    /**
     * 新闻列表视频
     */
    @GET("News/video")
    Observable<NewsListBean>   getNeswVideo();

    /**
     * 新闻列表活动
     */
    @GET("News/activity")
    Observable<NewsListBean>   getNeswActivity();

    /**
     * 新闻列表商学院
     */
    @GET("News/business")
    Observable<NewsListBean>   getNeswXue();

    /**
     * 新闻列表宴万家
     */
    @GET("News/yanwanjia")
    Observable<NewsListBean>   getNeswYan();

    /**
     *  宴会详情第一个页面
     */
    @GET("Details/message/id/{id}")
    Observable<BanquetBean>   getBanquet(@Path("id") String id);
    /**
     *  宴会详情第二个页面
     */
    @GET("Details/details/id/{id}")
    Observable<BanquetDetailBean>   getBanquetDetail(@Path("id") String id);
    /**
     *  宴会详情第三个页面
     */
    @GET("Details/message/id/{id}")
    Observable<BanquetBean>   getBanquetComment(@Path("id") String id);

    /**
     * 大型宴席
     */
    @GET("Large/large")
    Observable<BigYanBean>   getBigYan();

    /**
     * 我的收藏
     */
    @GET("Collection/mycollection/userid/{userid}")
    Observable<FavouriteBean>   getMyFavorite(@Path("userid") String userid);

    /**
     * 添加（或删除）到我的收藏
     */
    @POST("Collection/editcollection")
    Observable<FavoritrResultBean>  postMyFavorite(@Body KeepFavoriteBean keepFavoriteBean);

    /**
     *  删除到我的收藏
     */
    @POST("Collection/delete")
    Observable<FavoritrResultBean>  deleteMyFavorite(@Body KeepFavoriteBean keepFavoriteBean);

    /**
     * 检查是否收藏该数据
     */
    @GET("Collection/collection/userid/{userid}/dinnerid/{dinnerid}")
    Observable<CheckFavoriteBean>  getCheckFavorite(@Path("userid") int userid,@Path("dinnerid") int dinnerid);

    /**
     * 添加到购物车
     */
    @POST("Shopcar/editshopcar")
    Observable<FavoritrResultBean>  postAddCart(@Body PostAddCartBean postAddCartBean);

    /**
     * 查看我的购物车
     */
    @POST("Shopcar/shopcar/userid/{userid}")
    Observable<CartBean>  getMyCart(@Path("userid") int userid);


    /**
     *厨师购物车
     *@time2018/7/7/007 18:07
     */
    @POST("Shopcar/cookershopcar/userid/{userid}")
    Observable<ShoppingChefBean>  getMyChefCart(@Path("userid") int userid);

    /**
     * 删减购物车
     */
    @POST("Shopcar/deletes/id/{id}/num/{num}")
    Observable<FavoritrResultBean>  getChangeMyCart(@Path("id") int id,@Path("num") int num);

    /**
     * 删除chef购物车
     */
    @POST("Shopcar/deletecooker/id/{id}")
    Observable<FavoritrResultBean>  postDeleteMyChefCart(@Path("id") int id);

    /**
     * 删除的购物车
     */
    @POST("Shopcar/delete")
    Observable<FavoritrResultBean>  postDeleteCart(@Body PostAddCartBean postAddCartBean);

    /**
     *
     */
    @GET("Cook/cook")
    Observable<ChefMsgBean>  getChef();

    /**
     * 注册厨师
     */
    @POST("Cook/cookpersonal")
    Observable<FavoritrResultBean>  postCookRegister(@Body CookRegesigtBean cookRegesigtBean);

    /**
     * 分类厨师列表详情*
     */
    @GET("Cook/cooko/id/{id}")
    Observable<ChefClassifyBean>  getCookClassifyMsg(@Path("id") int id);

    /**
     * 需要招聘厨师列表
     */
    @GET("Cook/cookregister")
    Observable<RegListBean>  getCookRegList();

    /**
     * 厨师详情轮播图
     */
    @GET("Cook/cooko/id/{id}")
    Observable<ChefDetailBannerBean>  getChefDetailBanner(@Path("id") int id);

    /**
     * 厨师详情信息
     */
    @GET("Cook/cookdetails/id/{id}")
    Observable<ChefDetailMsgBean>      getChefDetailMsg(@Path("id") int id);
    /**
     * 厨师详情评论
     */
    @GET("Cook/cooko/id/{id}")
    Observable<ChefDetailCommentBean>  getChefDetailComment(@Path("id") int id);



    /**
     * 高端接待轮播图
     */
    @GET("Cook/cooko/id/{id}")
    Observable<ReceptionBannerBean>  getReceptionBanner();

    /**
     *  高端接待列表
     */
    @GET("Reception/reception")
    Observable<ReceptionDinnerBean>      getReceptionDinner();

    /**
     *  高端接待厨师
     */
    @GET("Cook/cooko/id/{id}")
    Observable<ReceptionChefBean>  getReceptionChef();

    /**
     * 更新App接口
     */
    @GET("5b30b495548b7a7574a1e097?")
    Observable<UpdateAppInfo> getUpdateInfo(@Query("api_token") String api_token);

    /**
     * 搜索热门关键词
     */
    @GET("Search/search")
    Observable<HotSearchBean>  getSearchHot();

    /**
     * 搜索返回内容
     */
    @POST("Search/searchadd")
    Observable<SearchResultBean>  getSearchResult(@Body SearchBodyBean searchBodyBean);

    /**
     * 底部栏第二个 分类 ,获取宴席
     */
    @GET("Cation/cationB")
    Observable<ClassifyBean>  getClassify();

    /**
     * 底部栏第二个 分类 ,获取厨师
     */
    @GET("Cation/CationtwoB")
    Observable<MainChefClassifyBean>  getClassifyChef();


    /**
     * 修改头像,userid是用path或者part都行。path需要去掉post的userid
     */
//    @HTTP(method = "DELETE",path = "/user/delete",hasBody = true)\
    @Multipart
    @POST("Userpersonal/userext/userid/{userid}")
    Observable<FavoritrResultBean>    postMineMsg(@Part MultipartBody.Part file,@Path("userid") int userid);


    /**
     * 修改个人信息
     */
    @POST("Userpersonal/userexto/")
    Observable<FavoritrResultBean>    postMineMsgAll(@Body ChangeMsgBean changeMsgBean);
//    @Body ChangeMsgBean changeMsgBean
    /**
     * 查看更多
     */
    @GET("Index/{more}")
    Observable<MoreYanBean>      getMore(@Path("more") String more);

    /**
     * 积分商城
     * @param id
     * @return
     */
    @GET("Userwallet/integral/id/{id}")
    Observable<JifenMainBean>      getJifen(@Path("id") int id);
}
