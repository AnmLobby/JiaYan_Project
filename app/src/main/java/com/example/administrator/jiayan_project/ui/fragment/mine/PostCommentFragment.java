package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.LinedEditText;
import com.example.administrator.jiayan_project.utils.weight.TagCloudView;
import com.hedgehog.ratingbar.RatingBar;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostCommentFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.bg)
    ImageView bg;
    @BindView(R.id.cuisine_name)
    TextView cuisineName;
    @BindView(R.id.nolo)
    TextView nolo;
    @BindView(R.id.cuisine_price)
    TextView cuisinePrice;
    @BindView(R.id.xiangqing)
    TextView xiangqing;
    @BindView(R.id.people)
    TextView people;
    @BindView(R.id.bucaocolor)
    TextView bucaocolor;
    @BindView(R.id.positionsTag)
    TagCloudView positionsTag;
    @BindView(R.id.edit_query)
    LinedEditText editQuery;
    @BindView(R.id.ratingbarba)
    RatingBar ratingbarba;
    @BindView(R.id.ratingbarb)
    RatingBar ratingbarb;
    @BindView(R.id.ratingbarc)
    RatingBar ratingbarc;
    @BindView(R.id.bt_post)
    Button btPost;


    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_post_comment, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();

        return layout;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle("发表评论");
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
