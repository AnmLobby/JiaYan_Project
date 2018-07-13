package com.example.administrator.jiayan_project.vlayout.chefDetail;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.youth.banner.Banner;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/7/13/013.
 */

public class MoreHolder  extends VlayoutBaseHolder<ChefDetailMsgBean> {
    @BindView(R.id.more_text)
    TextView more_text;
    public MoreHolder(View itemView) {
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
