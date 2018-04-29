package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;


import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.bucao_color)
    TextView bucaoColor;
    @BindView(R.id.yanseLayout)
    RelativeLayout yanseLayout;
    @BindView(R.id.zhuoshuLayout)
    RelativeLayout zhuoshuLayout;
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

    @OnClick({R.id.yanseLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yanseLayout:
                showSimpleBottomSheetList();
                break;
        }
    }
    @OnClick(R.id.zhuoshuLayout)
    public void onViewClicked() {
        showCommentDailog();
    }
    /**
     * 选择布草颜色，弹出对话框
     */
    private void showSimpleBottomSheetList() {
        new QMUIBottomSheet.BottomListSheetBuilder(getActivity())
                .addItem("普通红色")
                .addItem("普通白色")
                .addItem("普通黄色")
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                        dialog.dismiss();
                        bucaoColor.setText(tag);
                        Toast.makeText(getActivity(), "Item " + (position + 1), Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
    }


    private void showCommentDailog() {
        //R.style.***一定要写，不然不能充满整个屏宽，引用R.style.AppTheme就可以
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme).create();
        View view = View.inflate(getActivity(), R.layout.custom_dialog_zhuoshu, null);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);

        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        //window.setWindowAnimations(R.style.dialogStyle);
//        window.getDecorView().setPadding(0, 0, 0, 0);

        //设置dialog弹出后会点击屏幕或物理返回键，dialog不消失
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        window.setContentView(view);

        //获得window窗口的属性
        WindowManager.LayoutParams params = window.getAttributes();
        //设置窗口宽度为充满全屏
        params.width = WindowManager.LayoutParams.MATCH_PARENT;//如果不设置,可能部分机型出现左右有空隙,也就是产生margin的感觉
        //设置窗口高度为包裹内容
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;//显示dialog的时候,就显示软键盘
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;//就是这个属性导致window后所有的东西都成暗淡
        params.dimAmount = 0.5f;//设置对话框的透明程度背景(非布局的透明度)
        //将设置好的属性set回去
        window.setAttributes(params);

//        EditText etCommentbox = (EditText) view.findViewById(R.id.etCommentbox);
//        TextView tvComment = (TextView) view.findViewById(R.id.tvComment);
//        tvComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
    }



}
