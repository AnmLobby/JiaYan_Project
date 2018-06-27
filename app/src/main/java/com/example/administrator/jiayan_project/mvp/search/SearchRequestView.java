package com.example.administrator.jiayan_project.mvp.search;



import com.example.administrator.jiayan_project.enity.search.HotSearchBean;
import com.example.administrator.jiayan_project.enity.search.SearchResultBean;
import com.example.administrator.jiayan_project.mvp.base.IMvpBaseView;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/15.
 */

public interface SearchRequestView extends IMvpBaseView {
    void requestLoading();

    void resultSearchSuccess(SearchResultBean searchResultBean);

    void  hotListSuccess(HotSearchBean hotSearchBean);

    void resultFailure(String result);
}
