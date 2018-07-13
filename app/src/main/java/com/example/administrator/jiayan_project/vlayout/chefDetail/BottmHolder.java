package com.example.administrator.jiayan_project.vlayout.chefDetail;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/7/13/013.
 */

public class BottmHolder  extends VlayoutBaseHolder<ChefDetailMsgBean> {
    @BindView(R.id.bt_service)
    Button more_text;
    public BottmHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefDetailMsgBean bData) {
        super.setData(ps, bData);
        more_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}

