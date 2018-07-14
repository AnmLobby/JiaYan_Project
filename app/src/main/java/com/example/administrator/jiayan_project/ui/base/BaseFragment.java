package com.example.administrator.jiayan_project.ui.base;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;

import com.example.administrator.jiayan_project.utils.weight.CustomDialog;
import com.example.administrator.jiayan_project.utils.weight.image_detail.Config;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public  abstract class BaseFragment extends QMUIFragment {

    public BaseFragment() {

    }


    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 100);
    }

    public int getStatusBarHeight(BaseFragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public void CallPhone(){
        final String phone = "400-830-9328";
        final CustomDialog selfDialog = new CustomDialog(getActivity());
        selfDialog.setTitle("");
        selfDialog.setMessage(phone);
        selfDialog.setYesOnclickListener("呼叫", new CustomDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phone));
                startActivity(intent);
                selfDialog.dismiss();
            }
        });
        selfDialog.setNoOnclickListener("取消", new CustomDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {

                selfDialog.dismiss();
            }
        });
        selfDialog.show();
    }

    /**
     * 获取当前设备的屏幕密度等基本参数
     */
    protected void getDeviceDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Config.EXACT_SCREEN_HEIGHT = metrics.heightPixels;
        Config.EXACT_SCREEN_WIDTH = metrics.widthPixels;
    }


    public static void  HideSoftKeyBoardDialog(Activity activity){
        try{
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS, 0);
        }
        catch(Exception ex){

        }
    }

    /**
     * 6-7日添加测试空白bug是否修复
     * @param outState
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }
    //    mTopBar.setBackgroundDividerEnabled(false);//取消设置分割线
}
