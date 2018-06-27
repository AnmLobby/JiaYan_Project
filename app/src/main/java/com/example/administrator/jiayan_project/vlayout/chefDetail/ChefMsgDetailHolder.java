package com.example.administrator.jiayan_project.vlayout.chefDetail;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
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
    public ChefMsgDetailHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefDetailMsgBean cData) {
        super.setData(ps, cData);
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+cData.getChefData().get(0).getCookimg()).into(headimage);
        name.setText(cData.getChefData().get(0).getCookname());
        caixi.setText("菜系："+cData.getChefData().get(0).getCuisine());
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+cData.getCook().get(0).getCookerimg()).into(chefImage);
        chefLevel.setText(cData.getCook().get(0).getTitlename());
        chefService.setText("已服务: "+cData.getChefData().get(0).getSalesum() +"家" );

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
