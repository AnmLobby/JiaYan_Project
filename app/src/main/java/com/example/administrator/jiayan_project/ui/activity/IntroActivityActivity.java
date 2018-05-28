package com.example.administrator.jiayan_project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.jiayan_project.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivityActivity extends AppCompatActivity {

    //    @BindView(R.id.banner)
//    Banner banner;
//    @BindView(R.id.skip)
//    Button skip;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.guide_viewpager)
    ViewPager mPager;
    @BindView(R.id.guide_dots)
    LinearLayout mDotsLayout;
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_activity);
        ButterKnife.bind(this);


        initPager();
        mPager.setAdapter(new ViewPagerAdapter(viewList));
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                for (int i = 0; i < mDotsLayout.getChildCount(); i++) {
                    if(i == arg0){
                        mDotsLayout.getChildAt(i).setSelected(true);
                    } else {
                        mDotsLayout.getChildAt(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
//        QMUIStatusBarHelper.translucent(this); // 沉浸式状态栏
//        List<Integer> list=new ArrayList<>();
//        list.add(R.drawable.intro1);
//        list.add(R.drawable.intro2);
//        list.add(R.drawable.intro3);
//        banner.setImages(list)
//                .setOffscreenPageLimit(3)
//                .setImageLoader(new GlideImageLoader())
//                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
//                .isAutoPlay(false);
//        banner.start();
    }
    private void initPager(){
        viewList = new ArrayList<View>();
        int[] images = new int[] { R.drawable.intro1, R.drawable.intro2, R.drawable.intro3 };
//        int[] texts = new int[] { R.drawable.new_text1, R.drawable.new_text2, R.drawable.new_text3};
        for (int i = 0; i < images.length; i++) {
            viewList.add(initView(images[i]));
        }
        initDots(images.length);
    }

    private void initDots(int count){
        for (int j = 0; j < count; j++) {
            mDotsLayout.addView(initDot());
        }
        mDotsLayout.getChildAt(0).setSelected(true);
    }

    private View initDot(){
        return LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_dot, null);
    }

    private View initView(int res){
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_guide, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.iguide_img);
//        ImageView textview = (ImageView)view.findViewById(R.id.iguide_text);
        imageView.setImageResource(res);
//        textview.setImageResource(text);
        return view;
    }



    class ViewPagerAdapter extends PagerAdapter {

        private List<View> data;


        public ViewPagerAdapter(List<View> data)
        {
            super();
            this.data = data;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return data.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(data.get(position));
            return data.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(data.get(position));
        }

    }

    @OnClick({ R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.skip:
//                finishLogin();
//                break;
            case R.id.login:
                finishLogin();
                break;
        }
    }

    private void finishLogin() {
        Intent intent = new Intent(IntroActivityActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
//        overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);

    }
}
