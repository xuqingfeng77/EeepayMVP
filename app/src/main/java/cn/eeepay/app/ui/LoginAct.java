package cn.eeepay.app.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.OnClick;
import cn.eeepay.app.R;
import cn.eeepay.app.presenter.ILoginPresenter;
import cn.eeepay.app.presenter.implPresenter.LoginPresenterImpl;
import cn.eeepay.app.presenter.view.ILoginView;

public class LoginAct extends BaseActivity<ILoginPresenter> implements ILoginView{
    @BindView(R.id.login_btn)
    Button btnLogin;
    @BindView(R.id.login_txt)
    TextView txtShow;

    @Override
    protected int initView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected ILoginPresenter getmPresenter() {
        return new LoginPresenterImpl(mContext,this);
    }
    @OnClick({R.id.login_btn,R.id.login_txt})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_btn:
                mPresenter.getMeiziData(99);

                break;
            case R.id.login_txt:


                break;
        }


    }

    @Override
    public void setName(String name) {
       //来讲LoginPresenterImpl的回调
        txtShow.setText(name);
    }

    @Override
    public void setPwd(String name) {

    }

    @Override
    public void a(String name) {

    }

    @Override
    public void b(String name) {

    }

    @Override
    public void c(String name) {

    }

    @Override
    public void d(String name) {

    }

    @Override
    public void e(String name) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hidProgressDialog() {

    }

    @Override
    public void showError(String error) {

    }

}