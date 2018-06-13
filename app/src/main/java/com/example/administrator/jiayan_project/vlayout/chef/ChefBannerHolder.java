package com.example.administrator.jiayan_project.vlayout.chef;

import android.util.Log;
import android.view.View;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chef.ChefBannerBean;
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
 * Created by Administrator on 2018/6/11/011.
 */

public class ChefBannerHolder extends VlayoutBaseHolder<ChefBannerBean> {
        @BindView(R.id.banner)
        Banner banner;
    public ChefBannerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefBannerBean pData) {
        super.setData(ps, pData);

        List<String> listImage = new ArrayList<>();
        listImage.add("http://bmob-cdn-18241.b0.upaiyun.com/2018/06/11/591738b640ac699080fc1d808960a55f.png");
        listImage.add("http://bmob-cdn-18241.b0.upaiyun.com/2018/06/11/4e7dc4a840b92a6d8074914c45cea273.png");
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
