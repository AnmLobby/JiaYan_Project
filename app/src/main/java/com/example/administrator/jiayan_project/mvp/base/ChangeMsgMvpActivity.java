package com.example.administrator.jiayan_project.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vondear.rxtools.activity.ActivityBase;

/**
 * Created by Administrator on 2018/7/4/004.
 */





public abstract class ChangeMsgMvpActivity <V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> extends ActivityBase implements IMvpBaseView {

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }

        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        //绑定view
        presenter.attachMvpView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        if (presenter != null) {
            presenter.detachMvpView();
        }
    }

    /**
     * 创建Presenter
     * @return 子类自己需要的Presenter
     */
    protected abstract P createPresenter();

    /**
     * 获取Presenter
     * @return 返回子类创建的Presenter
     */
    public P getPresenter() {
        return presenter;
    }
}
