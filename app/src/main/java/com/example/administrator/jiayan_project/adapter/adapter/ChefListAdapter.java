package com.example.administrator.jiayan_project.adapter.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ChefListAdapter extends BaseQuickAdapter<ChefClassifyBean.ChefDataBean, BaseViewHolder> {
    public ChefListAdapter(@Nullable List<ChefClassifyBean.ChefDataBean> data) {
        super(R.layout.chef_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder viewHolder, final ChefClassifyBean.ChefDataBean item) {

        Glide.with(MyApplication.getContext())
                .load(Constants.BaseUrl+item.getCookimg())
                .crossFade()
                .into((ImageView) viewHolder.getView(R.id.image));


        viewHolder
                .setText(R.id.name, item.getRankname())
                .setText(R.id.buy_chefmoney,"¥ "+item.getPrice());
//         TextView textView1=viewHolder.getView(R.id.buy_money);
//        textView1.setText(item.getPrice());
        RadioGroup radioGroup=viewHolder.getView(R.id.group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case  R.id.btn1:
                        Log.e(TAG, "onCheckedChanged: "+i );
                        viewHolder.setText(R.id.buy_chefmoney,"¥ "+item.getPrice());
                        break;
                    case  R.id.btn2:
                        viewHolder.setText(R.id.buy_chefmoney,"¥ "+item.getYueprice());
                        break;
                    case  R.id.btn3:
                        viewHolder.setText(R.id.buy_chefmoney,"¥ "+item.getNianprice());
                        break;
                }
            }
        });
//        viewHolder.getView(R.id.group).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()){
//                    case  R.id.btn1:
//                        Log.e(TAG, "onClick: 顶顶顶顶顶顶顶" );
//                        viewHolder.setText(R.id.buy_chefmoney,"¥ "+item.getPrice());
//                        break;
//                    case  R.id.btn2:
//                        viewHolder.setText(R.id.buy_chefmoney,"¥ "+item.getYueprice());
//                        break;
//                    case  R.id.btn3:
//                        viewHolder.setText(R.id.buy_chefmoney,"¥ "+item.getNianprice());
//                        break;
//                }
//            }
//        });
    }
}
