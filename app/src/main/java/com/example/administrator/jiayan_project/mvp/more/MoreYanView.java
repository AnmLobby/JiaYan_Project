package com.example.administrator.jiayan_project.mvp.more;

import com.example.administrator.jiayan_project.enity.homepage.MoreYanBean;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3/003.
 */

public interface MoreYanView extends IMvpBaseView {
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
     * 登陆更多
     */
    void  resultMoreSuccess(MoreYanBean moreYanBean);


}
