package com.example.administrator.jiayan_project.vlayout.chefDetail;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.hedgehog.ratingbar.RatingBar;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ChefMsgDetailHolder extends VlayoutBaseHolder<ChefDetailMsgBean> {
    @BindView(R.id.headimage)
    CircleImageView headimage;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.ratingbar)
    RatingBar ratingbar;
    @BindView(R.id.rating_size)
    TextView ratingSize;
    @BindView(R.id.chef_image)
    ImageView chefImage;
    @BindView(R.id.chef_level)
    TextView chefLevel;
    @BindView(R.id.chef_service)
    TextView chefService;
    @BindView(R.id.caixi)
    TextView  caixi;
    @BindView(R.id.shenfen)
    ImageView shenfen;
    @BindView(R.id.chushi)
    ImageView chushi;
    @BindView(R.id.yingyang)
    ImageView yingyang;
    @BindView(R.id.qita)
    ImageView qita;
    @BindView(R.id.btnone) RadioButton btnone;
    @BindView(R.id.btntwo) RadioButton btntwo;
    @BindView(R.id.btnthree) RadioButton btnthree;
    @BindView(R.id.group) RadioGroup group;
    public ChefMsgDetailHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefDetailMsgBean cData) {
        super.setData(ps, cData);

        btnone.setText("包月服务"+"\n"+"¥ "+cData.getChefData().get(0).getPrice());
        btntwo.setText("半年服务"+"\n"+"¥ "+cData.getChefData().get(0).getBanprice());
        btnthree.setText("包年服务"+"\n"+"¥ "+cData.getChefData().get(0).getNianprice());
//        group.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mListener.onItemClick(mView, position, mData);
//
//            }
//        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                Log.e("打印看看", "输出： "+i+radioGroup. );
                mListener.onItemClick(mView, i, mData);
            }
        });
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+cData.getChefData().get(0).getCookimg()).into(headimage);
        name.setText(cData.getChefData().get(0).getCookname());
        caixi.setText("菜系："+cData.getChefData().get(0).getCuisine());
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+cData.getCook().get(0).getCookerimg()).into(chefImage);
        chefLevel.setText(cData.getCook().get(0).getTitlename());
        chefService.setText("已服务: "+cData.getChefData().get(0).getSalesum() +"家" );
        ratingbar.setStar(cData.getChefData().get(0).getRank_id());
        if (cData.getChefData().get(0).getCertificates()==1){
            shenfen.setBackgroundResource(R.drawable.peoplepapers_chcek);
        }
        if (cData.getChefData().get(0).getCertificates()==0){
            shenfen.setBackgroundResource(R.drawable.peoplepapers_chcekno);
        }
        if (cData.getChefData().get(0).getCookfront()==1){
            chushi.setBackgroundResource(R.drawable.chefpapers_check);
        }
        if (cData.getChefData().get(0).getCookfront()==0){
            chushi.setBackgroundResource(R.drawable.chefpapers_checkno);
        }
        if (cData.getChefData().get(0).getDietionfront()==1){
            yingyang.setBackgroundResource(R.drawable.nutritionpapers_check);
        }
        if (cData.getChefData().get(0).getDietionfront()==0){
            yingyang.setBackgroundResource(R.drawable.nutritionpapers_checkno);
        }
        if (cData.getChefData().get(0).getOther()==1){
            qita.setBackgroundResource(R.drawable.otherpapers_check);
        }
        if (cData.getChefData().get(0).getOther()==0){
            qita.setBackgroundResource(R.drawable.otherpapers_checkno);
        }
    }



}
