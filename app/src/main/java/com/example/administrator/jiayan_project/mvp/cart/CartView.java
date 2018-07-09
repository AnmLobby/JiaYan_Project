package com.example.administrator.jiayan_project.mvp.cart;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.cart.CartBean;
import com.example.administrator.jiayan_project.enity.cart.ShoppingChefBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

/**
 * Created by Administrator on 2018/5/16/016.
 */

public interface CartView extends IMvpBaseView {
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
     * 购物车
     */
    void resultUserSuccess(CartBean cartBean);

    /**
     * 删除购物车的item
     */
    void resultDeleteSuccess(FavoritrResultBean favoritrResultBean);

    /**
     * 删减购物车
     */
    void resultChangeSuccess(FavoritrResultBean favoritrResultBean);

    /**
     * 获取厨师购物车
     */
    void resultChefCartSuccess(ShoppingChefBean shoppingChefBean);

    /**
     * 删除购物车的chefitem
     */
    void resultDeleteChefSuccess(FavoritrResultBean favoritrResultBean);
}
