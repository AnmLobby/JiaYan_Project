package com.example.administrator.jiayan_project.vlayout.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.administrator.jiayan_project.vlayout.homepage.InflateConstants;


import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/7/14/014.
 */

public class SectionVlayoutBaseAdapter<T> extends DelegateAdapter.Adapter<SectionVlayoutBaseHolder<T>> {
    //上下文
    private Context mContext;
    //布局文件资源ID
    private int mResLayout;
    private VirtualLayoutManager.LayoutParams mLayoutParams;
    //数据源
    private List<T> mSectionDatas;
    //布局管理器
    private LayoutHelper mLayoutHelper;
    //继承VlayoutBaseHolder的Holder
    private Class<? extends SectionVlayoutBaseHolder> mClazz;
    //回调监听
    private SectionItemListener mListener;

    private String mText;

    public SectionVlayoutBaseAdapter(Context context) {
        mContext = context;
    }

    /**
     * <br/> 方法名称:SectionVlayoutBaseAdapter
     * <br/> 方法详述:构造函数
     * <br/> 参数:<同上申明>
     */
    public SectionVlayoutBaseAdapter(Context context, List<T> mSectionDatas, int mResLayout, Class<? extends SectionVlayoutBaseHolder> mClazz,
                              LayoutHelper layoutHelper, SectionItemListener listener,String text) {
        if (mClazz == null) {
            throw new RuntimeException("clazz is null,please check your params !");
        }
        if (mResLayout == 0) {
            throw new RuntimeException("res is null,please check your params !");
        }
        this.mContext = context;
        this.mResLayout = mResLayout;
        this.mLayoutHelper = layoutHelper;
        this.mClazz = mClazz;
        this.mListener = listener;
        this.mSectionDatas = mSectionDatas;
        this.mText=text;
        //this.mLayoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 
        // ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /**
     * <br/> 方法名称: SectionVlayoutBaseAdapter
     * <br/> 方法详述: 设置数据源
     * <br/> 参数: mSectionDatas，数据源
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setSectionData(List<T> mSectionDatas) {
        this.mSectionDatas = mSectionDatas;
        return this;
    }

    public SectionVlayoutBaseAdapter setSectionTitle(String text){
        this.mText=text;
        return  this;
    }
    /**
     * <br/> 方法名称: setItem
     * <br/> 方法详述: 设置单个数据源
     * <br/> 参数: mItem，单个数据源
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setSectionItem(T mItem) {
        this.mSectionDatas.add(mItem);
        return this;
    }

    /**
     * <br/> 方法名称: setLayout
     * <br/> 方法详述: 设置布局资源ID
     * <br/> 参数: mResLayout, 布局资源ID
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setSectionLayout(int mResLayout) {
        if (mResLayout == 0) {
            throw new RuntimeException("res is null,please check your params !");
        }
        this.mResLayout = mResLayout;
        return this;
    }

    /**
     * <br/> 方法名称: setLayoutHelper
     * <br/> 方法详述: 设置布局管理器
     * <br/> 参数: layoutHelper，管理器
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setSectionLayoutHelper(LayoutHelper layoutHelper) {
        this.mLayoutHelper = layoutHelper;
        return this;
    }

    /**
     * <br/> 方法名称: setHolder
     * <br/> 方法详述: 设置holder
     * <br/> 参数: mClazz,集成VlayoutBaseHolder的holder
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setSectionHolder(Class<? extends SectionVlayoutBaseHolder> mClazz) {
        if (mClazz == null) {
            throw new RuntimeException("clazz is null,please check your params !");
        }
        this.mClazz = mClazz;
        return this;
    }

    /**
     * <br/> 方法名称: setListener
     * <br/> 方法详述: 传入监听，方便回调
     * <br/> 参数: listener
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setSectionListener(SectionItemListener listener) {
        this.mListener = listener;
        return this;
    }

    /**
     * <br/> 方法名称: onCreateLayoutHelper
     * <br/> 方法详述: 继承elegateAdapter.Adapter后重写方法，告知elegateAdapter.Adapter使用何种布局管理器
     * <br/> 参数:
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }


    public HashMap<Integer, Object> tags = new HashMap<>();

    /**
     * <br/> 方法名称: setTag
     * <br/> 方法详述: 设置mObject
     * <br/> 参数: mObject
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */
    public SectionVlayoutBaseAdapter setTag(int tag, Object mObject) {
        if (mObject != null) {
            tags.put(tag, mObject);
        }
        return this;
    }

    /**
     * <br/> 方法名称: onCreateViewHolder
     * <br/> 方法详述: 解析布局文件，返回传入holder的构造器
     */
    @Override
    public SectionVlayoutBaseHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = InflateConstants.inflate(parent.getContext(), parent, mResLayout);
        if (tags != null && tags.size() > 0) {
            for (int tag : tags.keySet()) {
                view.setTag(tag, tags.get(tag));
            }
        }
        try {
            Constructor<? extends SectionVlayoutBaseHolder> mClazzConstructor = mClazz.getConstructor(View.class);
            if (mClazzConstructor != null) {
                return mClazzConstructor.newInstance(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <br/> 方法名称: onBindViewHolder
     * <br/> 方法详述: 绑定数据
     * <br/> 参数:
     * <br/> 返回值:  SectionVlayoutBaseAdapter
     */

    @Override
    public void onBindViewHolder(SectionVlayoutBaseHolder holder, int position) {
        holder.setSectionListener(mListener);
        holder.setSectionContext(mContext);
        holder.setSectionTitle(mText);
        holder.setSectionData(position, mSectionDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return mSectionDatas.size();
    }
}
