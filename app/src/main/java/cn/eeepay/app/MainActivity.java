package cn.eeepay.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import cn.eeepay.app.presenter.IPresenter;
import cn.eeepay.app.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.login)
    Button btnLogin;
    @BindView(R.id.reg)
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @OnClick({R.id.login,R.id.reg})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                break;
            case R.id.reg:
                break;
        }
    }

    @Override
    protected int initView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected IPresenter getmPresenter() {
        return null;
    }
}
