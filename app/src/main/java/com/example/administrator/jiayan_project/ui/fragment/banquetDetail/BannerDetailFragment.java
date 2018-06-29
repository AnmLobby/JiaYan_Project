package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BannerDetailFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    private static final String TAG = "BannerDetailFragment";
    @Override
    protected View onCreateView() {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banner_detail, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        Bundle bundle=getArguments();
        List<String> ca=bundle.getStringArrayList("id");
        banner.setImages(ca)
                .setImageLoader(new GlideImageLoader())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .isAutoPlay(false)
                .start();
        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
