package com.example.administrator.jiayan_project.adapter.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;

import java.util.List;

/**
 * Created by Administrator on 2018/5/2/002.
 */

public class TimeAdapter  extends RecyclerView.Adapter<TimeAdapter.ViewHolder>{

private List<String> data;
private int selectedPosition = 0;
private static final String TAG = "TimeAdapter";
public static class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_item;
    private TextView timer;

    public ViewHolder(View itemView) {
        super(itemView);

        tv_item = (TextView) itemView.findViewById(R.id.tv_item);
//        timer=itemView.findViewById(R.id.timer);
    }
}

    public  TimeAdapter(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.time_right_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final TimeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tv_item.setText(data.get(position));
        holder.tv_item.setTextColor(selectedPosition == position ? 0xff000000 : 0xffb5b6b2);

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

    private TimeAdapter.OnLeftItemClickListener mOnLeftItemClickListener;

    public void setOnLeftItemClickListener(TimeAdapter.OnLeftItemClickListener onLeftItemClickListener) {
        this.mOnLeftItemClickListener = onLeftItemClickListener;
    }

}
