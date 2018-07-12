package com.example.administrator.jiayan_project.adapter.comment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.MainClassifChefAdapter;
import com.example.administrator.jiayan_project.adapter.news.HotelUtils;
import com.example.administrator.jiayan_project.adapter.news.SectionedRecyclerViewAdapter;
import com.example.administrator.jiayan_project.enity.banquet.BanquetComentBean;
import com.example.administrator.jiayan_project.http.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/12/012.
 */

public class BanquetCommentAdapter extends SectionedRecyclerViewAdapter<CommentHolder, ImageHolder, RecyclerView.ViewHolder> {


        public List<BanquetComentBean.DataBean> allTagList;
        //public List<BanquetComentBean.DataBean> cAllTagList;
        private Context mContext;
        private LayoutInflater mInflater;
        private  int l;
        private SparseBooleanArray mBooleanMap;

    public BanquetCommentAdapter(Context context) {
            mContext = context;
            mInflater = LayoutInflater.from(context);
            mBooleanMap = new SparseBooleanArray();
            }

    public void setData(List<BanquetComentBean.DataBean> allTagList) {
            this.allTagList = allTagList;
            notifyDataSetChanged();
            }



    @Override
    protected int getSectionCount() {
            return HotelUtils.isEmpty(allTagList) ? 0 : allTagList.size();
            }

    @Override
    protected int getItemCountForSection(int section) {
        int count =0;
        if(null == allTagList.get(section).getImg()|| allTagList.get(section).getImg().size() ==0 ){
//               int count =0;
            if (count >= 80 && !mBooleanMap.get(section)) {
                count = 80;
            }
            l= 0;
        }else{
             count = allTagList.get(section).getImg().size();
            if (count >= 80 && !mBooleanMap.get(section)) {
                count = 80;
            }
            l= allTagList.get(section).getImg().size();
        }
            return HotelUtils.isEmpty(allTagList.get(section).getImg()) ? 0 : count;
            }

    //是否有footer布局
    @Override
    protected boolean hasFooterInSection(int section) {
            return false;
            }

    @Override
    protected CommentHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
            return new CommentHolder(mInflater.inflate(R.layout.banquet_comment_head, parent, false));
            }


    @Override
    protected RecyclerView.ViewHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
            return null;
            }

    @Override
    protected ImageHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
            return new ImageHolder(mInflater.inflate(R.layout.banquet_comment_image, parent, false));
            }


    @Override
    protected void onBindSectionHeaderViewHolder(final CommentHolder holder, final int section) {
            holder.openView.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
            boolean isOpen = mBooleanMap.get(section);
            String text = isOpen ? "展开" : "关闭";
            mBooleanMap.put(section, !isOpen);
            holder.openView.setText(text);
            notifyDataSetChanged();
            }
            });
//        if (l==0){
//            holder.titleView.setVisibility(View.GONE);
//        }
        holder.openView.setText(mBooleanMap.get(section) ? "关闭" : "展开");
        holder.num.setText(allTagList.get(section).getRank()+".0 分");
        holder.ratingBar.setStar(allTagList.get(section).getRank());
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+allTagList.get(section).getAvatar()).into(holder.circleImageView);
        holder.comment_time.setText(timestampDate(String.valueOf(allTagList.get(section).getCreatetime()), "yyyy-MM-dd HH:mm:ss"));
        holder.comment_name.setText(allTagList.get(section).getNickname());
        holder.comment.setText(allTagList.get(section).getContent());
        }

    public static String timestampDate(String str_num, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (str_num.length() == 13) {
            String date = sdf.format(new Date(Long.parseLong(str_num)));
//            LogUtil.debug("timestamp2Date" + "将13位时间戳:" + str_num + "转化为字符串:", date);
            return date;
        } else {
            String date = sdf.format(new Date(Integer.parseInt(str_num) * 1000L));
//            LogUtil.debug("timestamp2Date" + "将10位时间戳:" + str_num + "转化为字符串:", date);
            return date;
        }
    }
@Override
protected void onBindSectionFooterViewHolder(RecyclerView.ViewHolder holder, int section) {

        }

@Override
protected void onBindItemViewHolder(final ImageHolder holder, final int section, final int position) {
        Glide.with(MyApplication.getContext())
        .load(Constants.BaseUrl+allTagList.get(section).getImg().get(position))
        .crossFade()
        .into(holder.imageView);
    Log.e("888", "onBindItemViewHolder: "+Constants.BaseUrl+allTagList.get(section).getImg().get(position));
        if(mOnLeftItemClickListener!=null){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
            public void onClick(View v) {
                     mOnLeftItemClickListener.onLeftItemClick(section,position);
                    }
                 });
             }
        }
    public interface OnCommentItemClickChefListener{
        void onLeftItemClick(int section,int position);
}
    private OnCommentItemClickChefListener mOnLeftItemClickListener;

    public void setOnCommentItemClickListener(OnCommentItemClickChefListener onLeftItemClickListener) {
        this.mOnLeftItemClickListener = onLeftItemClickListener;
    }
}
