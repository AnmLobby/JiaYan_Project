package com.example.administrator.jiayan_project.ui.fragment.main;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MainActivity;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetOrderFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.ui.fragment.chef_service.ReceptionFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.DeliveryFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.JifenFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.RechargeFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.SetAddressFragment;
import com.example.administrator.jiayan_project.utils.weight.CustomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的页面，底部栏第四个
 */
public class MineFragment extends BaseFragment {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
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
                startFragment(new ReceptionFragment());
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
             Call();
            break;
            case R.id.kajuan_layout:
                startFragment(new SearchFragment());
//                startFragment(new BanquetOrderFragment());
                break;
            case R.id.fenxiang_layout:
                startFragment(new BlankOneFragment());
                Toast.makeText(MyApplication.getContext(), "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yuelayout:
                Toast.makeText(MyApplication.getContext(), "yuer", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chongzhilayout:
              startFragment(new RechargeFragment());
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


    private void Call() {
        if (ContextCompat.checkSelfPermission(MyApplication.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.CALL_PHONE)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                Toast.makeText(MyApplication.getContext(), "请授权！", Toast.LENGTH_LONG).show();

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }else{
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        }else {
            // 已经获得授权，可以打电话
            CallPhone();
        }
    }


}
