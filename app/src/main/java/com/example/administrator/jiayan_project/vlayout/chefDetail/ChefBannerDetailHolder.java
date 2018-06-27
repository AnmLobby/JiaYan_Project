package com.example.administrator.jiayan_project.vlayout.chefDetail;

import android.util.Log;
import android.view.View;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ChefBannerDetailHolder extends VlayoutBaseHolder<ChefDetailMsgBean> {
    @BindView(R.id.banner)
    Banner banner;
    public ChefBannerDetailHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefDetailMsgBean bData) {
        super.setData(ps, bData);
        List<String> list=new ArrayList<>();
        for (int i = 0; i <bData.getYii().size() ; i++) {
            list.add(Constants.BaseUrl+bData.getYii().get(i));
        }
        Log.e("88", "setData: "+list.size() );
        banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setBannerAnimation(Transformer.RotateDown)
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
