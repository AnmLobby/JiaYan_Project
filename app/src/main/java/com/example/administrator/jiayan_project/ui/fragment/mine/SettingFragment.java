package com.example.administrator.jiayan_project.ui.fragment.mine;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MainActivity;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.mine.UpdateAppInfo;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.setting.SettingPresenter;
import com.example.administrator.jiayan_project.mvp.setting.SettingView;
import com.example.administrator.jiayan_project.ui.activity.ChangeMineMsgActivity;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.MineFragment;
import com.example.administrator.jiayan_project.ui.fragment.yan_news.YanNewsMainFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.update.UpdateManager;
import com.example.administrator.jiayan_project.utils.weight.CustomDialog;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 设置
 */

public class SettingFragment extends AbstractMvpFragment<SettingView, SettingPresenter> implements SettingView {

    private static final String TAG = "SettingFragment";
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private PackageInfo packInfo = null;
    private  QMUICommonListItemView itemWithChevron2;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_setting, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        initList();
        PackageManager packageManager = MyApplication.getContext().getPackageManager();
        try {
            packInfo = packageManager.getPackageInfo(MyApplication.getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        getPresenter().clickRequestUpdate();
        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
    private void initList() {
        View.OnClickListener onClickListener = null;
        QMUICommonListItemView itemWithChevron = mGroupListView.createItemView("个人设置");
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron.setImageDrawable(getResources().getDrawable(R.mipmap.set));
        itemWithChevron.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyApplication.getContext(), ChangeMineMsgActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
//                Intent intentTranslucent = ChangeMineMsgActivity.createActivity(getContext(), true);
//                startActivity(intentTranslucent);
//                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);

//                startFragment(new ChangeMsgFragment());
//                startFragmentAndDestroyCurrent(new YanNewsMainFragment());
            }
        });

        QMUICommonListItemView itemWithChevron1 = mGroupListView.createItemView("消息提醒");
        itemWithChevron1.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron1.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron1.setImageDrawable(getResources().getDrawable(R.mipmap.notif));
        itemWithChevron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startFragment(new SettingFragment());
            }
        });
        itemWithChevron2 = mGroupListView.createItemView("版本更新");
        itemWithChevron2.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron2.setImageDrawable(getResources().getDrawable(R.mipmap.updata));
        itemWithChevron2.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUICommonListItemView itemWithChevron3 = mGroupListView.createItemView("关于我们");
        itemWithChevron3.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron3.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron3.setImageDrawable(getResources().getDrawable(R.mipmap.about));
        itemWithChevron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutFragment aboutFragment = new AboutFragment();
                startFragment(aboutFragment);
            }
        });
        QMUICommonListItemView itemWithChevron4 = mGroupListView.createItemView("联系我们");
        itemWithChevron4.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron4.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron4.setImageDrawable(getResources().getDrawable(R.mipmap.call));
        itemWithChevron4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Call();
            }
        });
        QMUICommonListItemView itemWithChevron5 = mGroupListView.createItemView("意见反馈");
        itemWithChevron5.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron5.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron5.setImageDrawable(getResources().getDrawable(R.mipmap.yijian));
        itemWithChevron5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


    }
        });
        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(itemWithChevron, onClickListener)
                .addTo(mGroupListView);
        QMUIGroupListView.newSection(getContext())
                .addItemView(itemWithChevron1, onClickListener)
                .addItemView(itemWithChevron2, onClickListener)
                .addItemView(itemWithChevron3, onClickListener)
                .addItemView(itemWithChevron4, onClickListener)
                .addTo(mGroupListView);
        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(itemWithChevron5, onClickListener)
                .addTo(mGroupListView);

    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        mTopBar.setTitle(ContantsName.SettingName);
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

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultUpdateSuccess(final UpdateAppInfo updateAppInfo) {
        final int localVersion = packInfo.versionCode;
        final int newVersion = Integer.valueOf(updateAppInfo.getVersion());
        if (newVersion > localVersion) {
            itemWithChevron2.showNewTip(true);
        }
        itemWithChevron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newVersion > localVersion) {
                    startUpdateApp(updateAppInfo);
                } else {
                    Toast.makeText(MyApplication.getContext(), "目前已是最新版本" + "V-" + packInfo.versionName, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void startUpdateApp(final UpdateAppInfo updateAppInfo) {
        new QMUIDialog.MessageDialogBuilder(getActivity())
                .setTitle("更新提示：")
                .setMessage("检测到新版本，是否更新？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        UpdateManager manager = new UpdateManager(MyApplication.getContext());
                        manager.startDownload(updateAppInfo.getInstall_url());
                        dialog.dismiss();
                    }
                })
                .show();
    }
    @Override
    public SettingPresenter createPresenter() {
        return new SettingPresenter();
    }
}
