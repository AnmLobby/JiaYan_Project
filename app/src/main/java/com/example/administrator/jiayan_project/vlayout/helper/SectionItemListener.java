package com.example.administrator.jiayan_project.vlayout.helper;

import android.view.View;

/**
 * Created by Administrator on 2018/7/14/014.
 */

public interface SectionItemListener<T>{
    void onSectionItemClick(View view,int section, int position,T mSectionData);
}
