package com.example.administrator.jiayan_project.vlayout.homepage;

import android.util.Log;
import android.view.View;


import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/11.
 */
//轮播图   http://jiayan.didi0769.com/index.php/api/index/huasuan
public class BannerHolder extends VlayoutBaseHolder<BannerBean> {
    @BindView(R.id.banner)
    Banner banner;

    private static final String TAG = "BannerHolder";
    public BannerHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void setData(int ps, BannerBean tData) {
        super.setData(ps, tData);
    if (tData.getData()!=null){
        List<String> listImage = new ArrayList<>();
        for (int i = 0; i <tData.getData().size();i++) {
            listImage.add(Constants.BaseUrl+tData.getData().get(i).getAdlink());

        }
        banner.setImages((List<?>)listImage)
                .setImageLoader(new GlideImageLoader())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .isAutoPlay(true);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
        banner.start();
    }

    }
}
