package com.example.administrator.jiayan_project.ui.fragment.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.DeliveryFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.JifenFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.SetAddressFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的页面，底部栏第四个
 */
public class MineFragment extends BaseFragment {
    private static final String TAG = "MineFragment";
    @BindView(R.id.yuelayout)
    LinearLayout yuelayout;
    @BindView(R.id.chongzhilayout)
    LinearLayout chongzhilayout;
    @BindView(R.id.jifenlayout)
    LinearLayout jifenlayout;

    @BindView(R.id.shoucang_layout)
    LinearLayout shoucangLayout;
    @BindView(R.id.huiyuan_layout)
    LinearLayout huiyuanLayout;
    @BindView(R.id.address_layout)
    LinearLayout addressLayout;
    @BindView(R.id.pingjia_layout)
    LinearLayout pingjiaLayout;
    @BindView(R.id.fuwu_layout)
    LinearLayout fuwuLayout;
    @BindView(R.id.kefu_layout)
    LinearLayout kefuLayout;
    @BindView(R.id.kajuan_layout)
    LinearLayout kajuanLayout;
    @BindView(R.id.fenxiang_layout)
    LinearLayout fenxiangLayout;
    @BindView(R.id.daifukuan_layout)
    LinearLayout daifukuanLayout;
    @BindView(R.id.yizhifu_layout)
    LinearLayout yizhifuLayout;
    @BindView(R.id.daipingjia_layout)
    LinearLayout daipingjiaLayout;
    @BindView(R.id.tuikuan_layout)
    LinearLayout tuikuanLayout;

    @Override
    protected View onCreateView() {
        CoordinatorLayout layout = (CoordinatorLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @OnClick({R.id.shoucang_layout, R.id.huiyuan_layout, R.id.address_layout, R.id.pingjia_layout, R.id.fuwu_layout, R.id.kefu_layout, R.id.kajuan_layout, R.id.fenxiang_layout, R.id.yuelayout, R.id.chongzhilayout, R.id.jifenlayout,R.id.daifukuan_layout, R.id.yizhifu_layout, R.id.daipingjia_layout, R.id.tuikuan_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shoucang_layout:
                Toast.makeText(MyApplication.getContext(), "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.huiyuan_layout:
                Toast.makeText(MyApplication.getContext(), "会有", Toast.LENGTH_SHORT).show();
                break;
            case R.id.address_layout:
                startFragment(new DeliveryFragment());
                break;
            case R.id.pingjia_layout:
                Toast.makeText(MyApplication.getContext(), "po", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuwu_layout:
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View detailcontent = inflater.inflate(R.layout.dialog_detail, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setView(detailcontent);
                builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                break;
            case R.id.kefu_layout:
                Toast.makeText(MyApplication.getContext(), "可服用", Toast.LENGTH_SHORT).show();
                break;
            case R.id.kajuan_layout:
                Toast.makeText(MyApplication.getContext(), "咯卷", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fenxiang_layout:
                Toast.makeText(MyApplication.getContext(), "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yuelayout:
                Toast.makeText(MyApplication.getContext(), "yuer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chongzhilayout:
                Toast.makeText(MyApplication.getContext(), "充值", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jifenlayout:
                startFragment(new JifenFragment());
                break;
            case R.id.daifukuan_layout:
                Toast.makeText(MyApplication.getContext(), "待付款", Toast.LENGTH_SHORT).show();

                break;
            case R.id.yizhifu_layout:
                Toast.makeText(MyApplication.getContext(), "已支付", Toast.LENGTH_SHORT).show();

                break;
            case R.id.daipingjia_layout:
                Toast.makeText(MyApplication.getContext(), "带评价", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tuikuan_layout:
                Toast.makeText(MyApplication.getContext(), "退款", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}
