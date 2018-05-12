package com.example.administrator.jiayan_project.ui.base;


import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;

import com.example.administrator.jiayan_project.utils.weight.CustomDialog;
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
}
