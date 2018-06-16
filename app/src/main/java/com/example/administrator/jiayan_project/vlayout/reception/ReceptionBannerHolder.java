package com.example.administrator.jiayan_project.vlayout.reception;

import android.util.Log;
import android.view.View;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
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
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionBannerHolder extends VlayoutBaseHolder<ReceptionBannerBean> {
    @BindView(R.id.banner)
    Banner banner;
    public ReceptionBannerHolder(View itemView) {
        super(itemView);
    }
    @Override
    public void setData(int ps, ReceptionBannerBean tData) {
        super.setData(ps, tData);
//        if (tData.getData()!=null){
            List<String> listImage = new ArrayList<>();
//            for (int i = 0; i <tData.getData().size();i++) {
//                listImage.add(Constants.BaseUrl+tData.getData().get(i).getAdcode());
//                Log.e(TAG, "setDaaa啊啊啊啊啊啊啊啊啊啊啊ta: "+Constants.BaseUrl+tData.getData().get(i).getAdcode() );
//            }
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
