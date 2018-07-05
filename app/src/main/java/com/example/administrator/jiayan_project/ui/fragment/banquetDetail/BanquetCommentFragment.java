package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

/**
 * 高级宴会菜单评论
 */
public class BanquetCommentFragment extends BaseFragment {


    private String dinnerid;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank_comment, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        EventBus.getDefault().register(this);
        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void ononMoonStickyEvent(StartNewsEvent startNewsEvent) {
        dinnerid = startNewsEvent.getMessage();
    }
}
