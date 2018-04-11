package com.example.administrator.jiayan_project.utils.util;

import android.graphics.Color;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public class VlayoutLayoutHelper {
    public static LayoutHelper getGridLayoutHelp(int spanCount) {
        //设置Grid布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(spanCount);
        //是否自动扩展
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setPadding(0, 30, 0, 10);
        gridLayoutHelper.setBgColor(Color.parseColor("#FFFFFF"));
        gridLayoutHelper.setVGap(0);
        return gridLayoutHelper;
    }
    public static  LayoutHelper getGridLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(4);
        gridHelper.setMarginTop(10);
        gridHelper.setWeights(new float[]{25.0f, 25.0f, 25.0f, 25.0f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(1);
        //设置水平方向条目的间隔
        gridHelper.setHGap(1);
        gridHelper.setMarginLeft(5);
        gridHelper.setMarginBottom(5);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(false);
        return gridHelper;
    }
    //滚出屏幕显示布局
    private LayoutHelper getScrollLayoutHelper() {
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(0, 0);
        scrollFixLayoutHelper.setShowType(2);
        scrollFixLayoutHelper.setPadding(0,0, 0, 0);
        scrollFixLayoutHelper.setSketchMeasure(true);
//        scrollFixLayoutHelper.setFixViewAnimatorHelper(onGetFixViewAppearAnimator());
        return scrollFixLayoutHelper;
    }
}
