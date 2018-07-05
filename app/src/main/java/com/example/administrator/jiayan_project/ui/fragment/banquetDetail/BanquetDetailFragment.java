package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.banquet.BanquetDetailBean;
import com.example.administrator.jiayan_project.mvp.banquetDetail.BanquetDetailPresenter;
import com.example.administrator.jiayan_project.mvp.banquetDetail.BanquetDetailView;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.HtmlUtil;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * 高级宴会菜单详情
 *
 */
public class BanquetDetailFragment  extends AbstractMvpFragment<BanquetDetailView, BanquetDetailPresenter> implements BanquetDetailView {

    private String dinnerid;
    @BindView(R.id.webview)
    WebView mWebView;
    private static final String TAG = "BanquetDetailFragment";
    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank_detail, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        EventBus.getDefault().register(this);
        getPresenter().clickRequestBanquet(dinnerid);
//        mWebView.loadUrl("https://www.jianshu.com/p/6e5eda3a51af");
//        initWebView();
        return layout;
    }

    private void initWebView() {
//        mWebView.getSettings().setJavaScriptEnabled(true);//支持javascript
//        mWebView.requestFocus();//触摸焦点起作用mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);//取消滚动条
//        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置允许js弹出alert对话框
//        WebSettings webSettings = mWebView.getSettings();
//        //设置自适应屏幕，两者合用
//        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
    }


    @Override
    public void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
//        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public BanquetDetailPresenter createPresenter() {
        return new BanquetDetailPresenter();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void requestLoading() {

    }
    private String getHtmlData(String bodyHTML) {
        String head = "<head><style>img{max-width: 100%; width:auto; height: auto;}</style></head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }
    @Override
    public void resultFailure(String result) {
        Log.e("", "resultFailur顶顶顶顶顶顶顶顶顶顶e: "+result );
    }

    @Override
    public void resultBanquetDetailSuccess(BanquetDetailBean banquetDetailBean) {
        mWebView.setDrawingCacheEnabled(true);
        mWebView.clearCache(true);
//        mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mWebView.loadDataWithBaseURL(null,getHtmlData(banquetDetailBean.getData().get(0).getComment()), "text/html", "utf-8", null);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i == 100) {
//                    tipDialog.dismiss();

//                    laout.setVisibility(View.VISIBLE);
                }
            }
        });
        String url=getHtmlData(banquetDetailBean.getData().get(0).getComment());
        Log.e(TAG, "resultBanquetDetailSuccess: "+url );
        //        mWebView.loadUrl("https://www.jianshu.com/p/6e5eda3a51af");
//        mWebView.loadData(banquetDetailBean.getData().get(0).getComment(), HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
    }
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void ononMoonStickyEvent(StartNewsEvent startNewsEvent) {
        dinnerid = startNewsEvent.getMessage();
    }
}
