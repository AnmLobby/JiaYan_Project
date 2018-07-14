package com.example.administrator.jiayan_project.vlayout.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;



import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/14/014.
 */

public class SectionVlayoutBaseHolder<T> extends RecyclerView.ViewHolder {
    public SectionItemListener mListener;
    public Context mContext;
    public View mView;
    public T mSectionData;
    public int position;
    public String mText;

    public SectionVlayoutBaseHolder(View itemView) {
        super(itemView);
        mView = itemView;
        ButterKnife.bind(this, itemView);
        Sectioninit();
    }

    public void Sectioninit() {

    }

    public void setSectionContext(Context context) {
        mContext = context;
    }
    public void setSectionTitle(String text){
        mText=text;
    }
    public void setSectionListener(SectionItemListener listener) {
        mListener = listener;
    }

    public void setSectionData(int ps, T mData) {
        this.mSectionData = mData;
        position = ps;
    }

}
