package com.example.administrator.jiayan_project.adapter.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;


import java.util.List;

/**
 * Created by Administrator on 2018/5/2/002.
 */

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder>{

    private List<String> data;
    private int selectedPosition = 0;
    private static final String TAG = "DateAdapter";
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_item;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_item = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    public  DateAdapter(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    @Override
    public DateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DateAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.date_left_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DateAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tv_item.setText(data.get(position));
        holder.tv_item.setTextColor(selectedPosition == position ? 0xff3dbcc6 : 0xff333333);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnLeftItemClickListener != null) {
                    setSelectedPosition(position);
                    notifyDataSetChanged();
                    mOnLeftItemClickListener.onLeftItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void  setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public void notifySelectedPositionByHeader(String header) {
        if (data == null) {
            return;
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(header)) {
                this.selectedPosition = i;
                notifyDataSetChanged();
                break;
            }
        }
    }

    public String getSelectedData() {
        return data == null ? "" : data.get(this.selectedPosition);
    }

    public interface OnLeftItemClickListener{
        void onLeftItemClick(int position);
    }

    private DateAdapter.OnLeftItemClickListener mOnLeftItemClickListener;

    public void setOnLeftItemClickListener(DateAdapter.OnLeftItemClickListener onLeftItemClickListener) {
        this.mOnLeftItemClickListener = onLeftItemClickListener;
    }

}
