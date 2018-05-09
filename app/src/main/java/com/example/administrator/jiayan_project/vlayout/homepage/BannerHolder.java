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
        Log.e(TAG, "setData: "+tData.getAdlink() );
//        if (tData.getIssueList() != null) {
            List<String> listImage = new ArrayList<>();
            listImage.add(Constants.BaseUrl+tData.getAdlink());
//            List<String> listTitle = new ArrayList<>();
//            for (int i =0; i <tData.getIssueList().get(0).getItemList().size(); i++) {
//                    if (tData.getIssueList().get(0).getItemList().get(i).getType().equals("video")) {
//                        listImage.add(tData.getIssueList().get(0).getItemList().get(i).getData().getCover().getFeed());
//                        listTitle.add(tData.getIssueList().get(0).getItemList().get(i).getData().getTitle());
//                    } else {
//
//                        Log.e(TAG, "出错了");
//                }
//            }
        Log.e(TAG, "set88 "+listImage.size() );
        Log.e(TAG, "setData: "+Constants.BaseUrl+tData.getAdlink() );
            banner.setImages((List<?>) listImage)
                    .setImageLoader(new GlideImageLoader())
                    .setBannerStyle(BannerConfig.CENTER)
                    .isAutoPlay(true);
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    mListener.onItemClick(mView, position, mData);
                }
            });
            banner.start();
//        }
    }
}
