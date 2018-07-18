package com.example.administrator.jiayan_project.ui.fragment.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.db.greendao.UserController;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.mine.MinePresenter;
import com.example.administrator.jiayan_project.mvp.mine.MineView;
import com.example.administrator.jiayan_project.ui.activity.ChangeMineMsgActivity;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetDetailFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.CommentViewPagerFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.DeliveryFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.JifenFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.MyFavoriteFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.RechargeFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.SettingFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine_payorder.OrderBlankFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.vondear.rxtools.RxImageTool;
import com.vondear.rxtools.module.wechat.share.WechatShareModel;
import com.vondear.rxtools.module.wechat.share.WechatShareTools;
import com.vondear.rxtools.view.dialog.RxDialogSure;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import q.rorbin.badgeview.QBadgeView;

/**
 * 我的页面，底部栏第四个
 */
public class MineFragment extends AbstractMvpFragment<MineView, MinePresenter> implements MineView {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final String TAG = "MineFragment";
    @BindView(R.id.yuelayout) LinearLayout yuelayout;
    @BindView(R.id.chongzhilayout) LinearLayout chongzhilayout;
    @BindView(R.id.jifenlayout) LinearLayout jifenlayout;
    @BindView(R.id.shoucang_layout) LinearLayout shoucangLayout;
    @BindView(R.id.huiyuan_layout) LinearLayout huiyuanLayout;
    @BindView(R.id.address_layout) LinearLayout addressLayout;
    @BindView(R.id.pingjia_layout) LinearLayout pingjiaLayout;
    @BindView(R.id.fuwu_layout) LinearLayout fuwuLayout;
    @BindView(R.id.kefu_layout) LinearLayout kefuLayout;
    @BindView(R.id.kajuan_layout) LinearLayout kajuanLayout;
    @BindView(R.id.fenxiang_layout) LinearLayout fenxiangLayout;
    @BindView(R.id.daifukuan_layout) LinearLayout daifukuanLayout;
    @BindView(R.id.yizhifu_layout) LinearLayout yizhifuLayout;
    @BindView(R.id.daipingjia_layout) LinearLayout daipingjiaLayout;
    @BindView(R.id.tuikuan_layout) LinearLayout tuikuanLayout;
    @BindView(R.id.name) TextView name;
    @BindView(R.id.iv_head) QMUIRadiusImageView ivHead;
    @BindView(R.id.daifukuantext) TextView daifukuantext;
    @BindView(R.id.yizhifutext) TextView yizhifutext;
    @BindView(R.id.daipingjiatext) TextView daipingjiatext;
    @BindView(R.id.shouhoutext) TextView shouhoutext;
    @BindView(R.id.daifukuan) ImageView daifukuan;
    @BindView(R.id.yizhifu) ImageView yizhifu;
    @BindView(R.id.daipingjia) ImageView daipingjia;
    @BindView(R.id.shouhou) ImageView shouhou;
    private WechatShareModel mWechatShareModel;
    private List<KeepUserBean> list;
    private List<KeepUserBean> keepUserBeans;
    private String userPhone;
    private Boolean isPause = false;
    private UserController userController;

    @Override
    protected View onCreateView() {
        CoordinatorLayout layout = (CoordinatorLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        userController = UserController.getInstance();
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)
                .limit(1)
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        if (list.get(0).getAvatar().isEmpty()) {
            Glide.with(MyApplication.getContext()).load(R.drawable.bg_people).placeholder(R.drawable.bg_people).error(R.drawable.bg_people).into(ivHead);
        } else {
            Glide.with(MyApplication.getContext()).load(Constants.BaseUrl + list.get(0).getAvatar()).placeholder(R.drawable.bg_people).error(R.drawable.bg_people).into(ivHead);
        }
        userPhone = list.get(0).getUsername();
        name.setText(list.get(0).getNickname());
        getPresenter().clickPostMessage(userPhone);
        UserController userController = UserController.getInstance();
        new QBadgeView(MyApplication.getContext())
                .bindTarget(daifukuanLayout)
                .setBadgeGravity(Gravity.END | Gravity.TOP)
                .setBadgePadding(0, true)
                .setExactMode(true)
                .setGravityOffset(65, 0, false)
                .setBadgeNumber(5);
        new QBadgeView(MyApplication.getContext())
                .bindTarget(yizhifuLayout)
                .setBadgeGravity(Gravity.END | Gravity.TOP)
                .setBadgePadding(0, true)
                .setExactMode(true)
                .setGravityOffset(65, 0, false)
                .setBadgeNumber(1);
        new QBadgeView(MyApplication.getContext())
                .bindTarget(daipingjiaLayout)
                .setBadgeGravity(Gravity.END | Gravity.TOP)
                .setBadgePadding(0, true)
                .setExactMode(true)
                .setGravityOffset(65, 0, false)
                .setBadgeNumber(1);
        new QBadgeView(MyApplication.getContext())
                .bindTarget(tuikuanLayout)
                .setBadgeGravity(Gravity.END | Gravity.TOP)
                .setBadgePadding(0, true)
                .setExactMode(true)
                .setGravityOffset(75, 0, false)
                .setBadgeNumber(0);
        return layout;
    }

    @OnClick({R.id.shoucang_layout, R.id.huiyuan_layout, R.id.address_layout, R.id.pingjia_layout, R.id.fuwu_layout, R.id.kefu_layout, R.id.kajuan_layout, R.id.fenxiang_layout, R.id.yuelayout, R.id.chongzhilayout, R.id.jifenlayout, R.id.daifukuan_layout, R.id.yizhifu_layout, R.id.daipingjia_layout, R.id.tuikuan_layout, R.id.iv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shoucang_layout:
//                Toast.makeText(MyApplication.getContext(), "收藏", Toast.LENGTH_SHORT).show();
                startFragment(new MyFavoriteFragment());
//                startFragment(new ReceptionFragment());
                break;
            case R.id.huiyuan_layout:
//                startFragment(new BigYanFragment());
//                Toast.makeText(MyApplication.getContext(), "会员", Toast.LENGTH_SHORT).show();
                break;
            case R.id.address_layout:
                startFragment(new DeliveryFragment());
                break;
            case R.id.pingjia_layout:
                startFragment(new CommentViewPagerFragment());
//                startFragment(new MyCommentDinnerFragment());
//                startFragment(new PostCommentFragment());
//                Toast.makeText(MyApplication.getContext(), "评价", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuwu_layout:
                final RxDialogSure rxDialogSure = new RxDialogSure(getActivity());//提示弹窗
                rxDialogSure.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSure.cancel();
                    }
                });
                rxDialogSure.show();
                break;
            case R.id.kefu_layout:
                Call();
                break;
            case R.id.kajuan_layout:

                startFragment(new SettingFragment());
                break;
            case R.id.fenxiang_layout:
                showShareDialog();
                break;
            case R.id.yuelayout:
//                Toast.makeText(MyApplication.getContext(), "余额", Toast.LENGTH_SHORT).show();
                startFragment(new BanquetDetailFragment());

                break;
            case R.id.chongzhilayout:
//                Toast.makeText(MyApplication.getContext(), "充值", Toast.LENGTH_SHORT).show();
                startFragment(new RechargeFragment());
                break;
            case R.id.jifenlayout:
                startFragment(new JifenFragment());
//                Toast.makeText(MyApplication.getContext(), "积分", Toast.LENGTH_SHORT).show();
                break;
            case R.id.daifukuan_layout:
//                Toast.makeText(MyApplication.getContext(), "待付款", Toast.LENGTH_SHORT).show();
                OrderBlankFragment orderBlankFragment = new OrderBlankFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("index", 0);
                orderBlankFragment.setArguments(bundle);
                startFragment(orderBlankFragment);
                break;
            case R.id.yizhifu_layout:
//                Toast.makeText(MyApplication.getContext(), "已支付", Toast.LENGTH_SHORT).show();
                OrderBlankFragment orderBlankFragment1 = new OrderBlankFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("index", 1);
                orderBlankFragment1.setArguments(bundle1);
                startFragment(orderBlankFragment1);
                break;
            case R.id.daipingjia_layout:
//                Toast.makeText(MyApplication.getContext(), "带评价", Toast.LENGTH_SHORT).show();
                OrderBlankFragment orderBlankFragment2 = new OrderBlankFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("index", 2);
                orderBlankFragment2.setArguments(bundle2);
                startFragment(orderBlankFragment2);
                break;
            case R.id.tuikuan_layout:
//                Toast.makeText(MyApplication.getContext(), "退款", Toast.LENGTH_SHORT).show();
                OrderBlankFragment orderBlankFragment3 = new OrderBlankFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("index", 3);
                orderBlankFragment3.setArguments(bundle3);
                startFragment(orderBlankFragment3);
                break;
            case R.id.iv_head:

                Intent intent = new Intent(MyApplication.getContext(), ChangeMineMsgActivity.class);
                startActivity(intent);
                isPause = true;
                getActivity().overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
                break;
        }
    }

    /**
     * 分享选择
     */
    private void showShareDialog() {

        String url = "https://fir.im/gn4w";//网页链接

        String description = "一款能在线预定宴席，厨师注册，预定的app。你也赶紧来看看吧！";//描述

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);//获取Bitmap
        byte[] bitmapByte = RxImageTool.bitmap2Bytes(bitmap, Bitmap.CompressFormat.PNG);//将 Bitmap 转换成 byte[]

        mWechatShareModel = new WechatShareModel(url, description, "", bitmapByte);

        //Friend 分享微信好友,Zone 分享微信朋友圈,Favorites 分享微信收藏
//        WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Friend);//分享操作
        //Friend 分享微信好友,Zone 分享微信朋友圈,Favorites 分享微信收藏
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        QMUIBottomSheet.BottomGridSheetBuilder builder = new QMUIBottomSheet.BottomGridSheetBuilder(getActivity());
        builder.addItem(R.mipmap.icon_more_operation_share_friend, "分享到微信", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_moment, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView) {
                        dialog.dismiss();
                        int tag = (int) itemView.getTag();
                        switch (tag) {
                            case TAG_SHARE_WECHAT_FRIEND:
                                Log.e(TAG, "onClick: ");
                                WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Friend);//分享操作
                                break;
                            case TAG_SHARE_WECHAT_MOMENT:
                                WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Zone);//分享操作
                                break;
                        }
                    }
                }).build().show();

    }


    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isPause) { //判断是否暂停
            isPause = false;
            Observable.timer(100, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                            keepUserBeans = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                                    .offset(0)
                                    .limit(1)
                                    .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                                    .build()
                                    .list();
                            name.setText(keepUserBeans.get(0).getNickname());
                            if (keepUserBeans.get(0).getAvatar().isEmpty()) {
                                Glide.with(MyApplication.getContext()).load(R.drawable.bg_people).placeholder(R.drawable.bg_people).error(R.drawable.bg_people).into(ivHead);
                            } else {
                                Glide.with(MyApplication.getContext()).load(Constants.BaseUrl + keepUserBeans.get(0).getAvatar()).placeholder(R.drawable.bg_people).error(R.drawable.bg_people).into(ivHead);
                            }
                        }
                    });
        }
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    private void Call() {
        if (ContextCompat.checkSelfPermission(MyApplication.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
        } else {
            // 已经获得授权，可以打电话
            CallPhone();
        }
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: " + result);
    }

    @Override
    public void resultLoginSuccess(List<LoginBean> loginBean) {

        name.setText(loginBean.get(0).getNickname());
        if (loginBean.get(0).getAvatar() == null || loginBean.get(0).getAvatar().isEmpty()) {
            Glide.with(MyApplication.getContext()).load(R.drawable.bg_people).placeholder(R.drawable.bg_people).error(R.drawable.bg_people).into(ivHead);
        } else {
            Glide.with(MyApplication.getContext()).load(Constants.BaseUrl + loginBean.get(0).getAvatar()).placeholder(R.drawable.bg_people).error(R.drawable.bg_people).into(ivHead);
        }
        KeepUserBean addressBean = new KeepUserBean();
        addressBean.setId(list.get(0).getId());
        addressBean.setUserId(loginBean.get(0).getId());
        addressBean.setAge(loginBean.get(0).getAge());
        addressBean.setAvatar(loginBean.get(0).getAvatar());
        addressBean.setGender(loginBean.get(0).getGender());
        addressBean.setGroup_id(loginBean.get(0).getGroup_id());
        addressBean.setLevel(loginBean.get(0).getLevel());
        addressBean.setMobile(loginBean.get(0).getMobile());
        addressBean.setNickname(loginBean.get(0).getNickname());
        addressBean.setUsername(loginBean.get(0).getUsername());
        userController.update(addressBean);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
