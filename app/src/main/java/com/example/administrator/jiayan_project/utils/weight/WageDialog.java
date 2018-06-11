package com.example.administrator.jiayan_project.utils.weight;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.fragment.mine.SetAddressFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

/**
 * Created by Administrator on 2018/6/11/011.
 */

public class WageDialog extends Dialog {
    private QMUITopBar qmuiTopBar;
    private onCloseOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    public WageDialog(@NonNull Context context) {
        super(context);
    }

    public WageDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected WageDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wage_dialog);
        qmuiTopBar=findViewById(R.id.mtopbar);
        qmuiTopBar.setTitle("薪资标准");
        qmuiTopBar.addRightImageButton(R.mipmap.wage_close, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesOnclickListener.onYesClick();
            }
        });
//        //按空白处不能取消dialog
//        setCanceledOnTouchOutside(false);

    }
    /**
     * 设置确定按钮的显示内容和监听
     *
     */
    public void setYesOnclickListener(onCloseOnclickListener onYesOnclickListener) {

        this.yesOnclickListener = onYesOnclickListener;
    }
    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onCloseOnclickListener {
        public void onYesClick();
    }

}
