package com.example.administrator.jiayan_project.utils.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by 鱼握拳 on 2018/4/19.
 */

public class AlertUtils {
    private static Dialog dlg;
    public static void showAlert(Context context, String message,
                                 CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener,
                                 CharSequence negativeButtontxt, DialogInterface.OnClickListener negativeListener) {
        dlg = new AlertDialog.Builder(context)
                .setTitle("温馨提示")
                .setPositiveButton(positiveButtontxt, positiveListener)
                .setNegativeButton(negativeButtontxt, negativeListener)
                .setMessage(message)
                .setCancelable(true)
                .create();
        dlg.show();
    }
}
