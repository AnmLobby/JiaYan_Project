package com.example.administrator.jiayan_project.utils.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import com.example.administrator.jiayan_project.MyApplication;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 鱼握拳 on 2017/12/19.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        if (Util.isOnMainThread()) {
            Glide.with(MyApplication.getContext()).load(path).into(imageView);
        }
//        Glide.with(context).load(path).into(imageView);
    }
}
