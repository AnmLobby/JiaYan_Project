package com.example.administrator.jiayan_project.ui.fragment.recruit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MainActivity;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.mvp.cook_regesigt.CookRegisterPesenter;
import com.example.administrator.jiayan_project.mvp.cook_regesigt.CookRegisterView;
import com.example.administrator.jiayan_project.ui.base.AddressBaseFragment;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.base.RegisBaseMvpFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.DateUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.youth.picker.PickerView;
import com.youth.picker.entity.PickerData;
import com.youth.picker.listener.OnPickerClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class CookRegisterPostFragment extends RegisBaseMvpFragment<CookRegisterView, CookRegisterPesenter> implements CookRegisterView {
        @BindView(R.id.mtopbar)
        QMUITopBar mTopBar;
        @BindView(R.id.nameText)
        EditText nameText;
        @BindView(R.id.age)
        EditText age;
        @BindView(R.id.radiogroup1)
        RadioGroup radiogroup;
        @BindView(R.id.et_area)
        TextView etArea;
        @BindView(R.id.workunit)
        EditText workunit;
        @BindView(R.id.phone)
        EditText phone;
        @BindView(R.id.chefage)
        EditText chefage;
        @BindView(R.id.btn_signup)
        AppCompatButton btnPostMsg;
        @BindView(R.id.selectare)
        RelativeLayout selectare;
        private PickerView pickerView;
        private static final String TAG = "CookRegisterPostFragmen";
        private String sexMsg;
        private String a, b, c, d, e, f, g,id;
        private PickerData data;
        @Override
        protected View onCreateView () {
        final FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cook_register_sure, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
            Bundle bundle=getArguments();
            id= String.valueOf(bundle.getInt("id"));
        Observable.timer(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        initProvinceDatas();
                        data = new PickerData();
                        //设置数据，有多少层级自己确定
                        data.setFirstDatas(mProvinceDatas);
                        data.setSecondDatas(mCitisDatasMap);
                        data.setThirdDatas(mDistrictDatasMap);
                        data.setFourthDatas(new HashMap<String, String[]>());
                        pickerView = new PickerView(getActivity(), data);
                        selectare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                hintKbTwo();
                                pickerView.show(selectare);
                            }
                        });
                        pickerView.setOnPickerClickListener(new OnPickerClickListener() {
                            //选择列表时触发的事件
                            @Override
                            public void OnPickerClick(PickerData pickerData) {
                                //想获取单个选择项 PickerData内也有方法（弹出框手动关闭）

                                etArea.setText(pickerData.getSelectText());
                                pickerView.dismiss();//关闭选择器
                            }

                            //点击确定按钮触发的事件（自动关闭）
                            @Override
                            public void OnPickerConfirmClick(PickerData pickerData) {
                                etArea.setText(pickerData.getSelectText());
                            }
                        });

                    }
                });

        ButterKnife.bind(this, layout);
        initTopBar();
        init();
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = layout.findViewById(radiogroup.getCheckedRadioButtonId());

                sexMsg = rb.getText().toString();
            }
        });
        btnPostMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMsgInit();

            }
        });


        return layout;
    }


    private void checkMsgInit() {


        a=nameText.getText().toString();
        b=age.getText().toString();
        c=sexMsg;
        d=etArea.getText().toString();
        e=workunit.getText().toString();
        f=phone.getText().toString();
        g=chefage.getText().toString();
        if (TextUtils.isEmpty(a)){
            Toast.makeText(MyApplication.getContext(), "名字不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(b)){
            Toast.makeText(MyApplication.getContext(), "年龄不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(c)){
            Toast.makeText(MyApplication.getContext(), "请选择你的性别信息", Toast.LENGTH_SHORT).show();
            return;
        }
        if (d.equals("选择地区")){
            Toast.makeText(MyApplication.getContext(), "请选择目前你所在的工作城市", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(e)){
            e="无";
        }
        if (TextUtils.isEmpty(f)){
            Toast.makeText(MyApplication.getContext(), "手机号码不能为空，否则我们不能与你取得联系。", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(g)){
            Toast.makeText(MyApplication.getContext(), "厨龄不能为空，若无经验请输入0", Toast.LENGTH_SHORT).show();
            return;
        }
        getPresenter().clickRequestCart(id,a,b,c,d,f,g);

    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    private void init() {

    }

    private void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getActivity().getCurrentFocus()!=null){
            if (getActivity().getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    private void initTopBar() {

        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("填写个人信息");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultRegisterSuccess(FavoritrResultBean favoritrResultBean) {
                if (favoritrResultBean.getCode()==200){
                    final QMUITipDialog    tipDialog = new QMUITipDialog.Builder(getContext())
                            .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                            .setTipWord(favoritrResultBean.getMsg())
                            .create();
                    tipDialog.show();
                    Observable.timer(2000, TimeUnit.MILLISECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<Long>() {
                                @Override
                                public void accept(Long aLong) throws Exception {
                                tipDialog.dismiss();
                                }
                            });
                    popBackStack();
                }

    }

    @Override
    public CookRegisterPesenter createPresenter() {
        return new CookRegisterPesenter();
    }
}
