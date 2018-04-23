package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;


import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 高级宴会菜单
 */

public class BanquetFragment extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.qmui_layout)
    QMUILinearLayout mTestLayout;
    @BindView(R.id.twolayout)
    QMUILinearLayout twolayout;
    @BindView(R.id.buy_money)
    TextView buyMoney;
    @BindView(R.id.money_before)
    TextView moneyBefore;
    private float mShadowAlpha = 0.25f;
    private int mShadowElevationDp = 5;
    private int mRadius;
    List<String> listImage = new ArrayList<>();
    private static final String TAG = "BanquetFragment";

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banquet, null);
        ButterKnife.bind(this, layout);
        initBanner();
        initQmuiLayout();
        initTextViewMoney();
        return layout;
    }

    private void initTextViewMoney() {
        moneyBefore.setText("原价：¥ 666 /套");
        moneyBefore.getPaint().setFlags(
                Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
    }

    private void initQmuiLayout() {

        mRadius = QMUIDisplayHelper.dp2px(getContext(), 10);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(getContext(), mShadowElevationDp),
                mShadowAlpha);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(getActivity(), mShadowElevationDp), mShadowAlpha);
//        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_RIGHT);
//        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_BOTTOM);
        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_NONE);

    }

    private void initBanner() {
        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
        listImage.add("http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg");
        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
        listImage.add("http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg");
        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");

        Log.e(TAG, "initBanner: " + listImage.size());
        banner.setImages(listImage)
                .setImageLoader(new GlideImageLoader())
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .isAutoPlay(false)
                .start();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
