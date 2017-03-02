package cn.eeepay.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import cn.eeepay.app.presenter.IPresenter;
import cn.eeepay.app.ui.BaseActivity;
import cn.eeepay.app.ui.LoginAct;

public class MainActivity extends BaseActivity {

    @BindView(R.id.login)
    Button btnLogin;
    @BindView(R.id.reg)
    Button btnReg;


    @OnClick({R.id.login,R.id.reg})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                Intent intent =new Intent(this, LoginAct.class);
                startActivity(intent);
                break;
            case R.id.reg:
                Toast.makeText(mContext,"你点我了",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected int initView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext, LoginAct.class);
                startActivity(intent);
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"你点我了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected IPresenter getmPresenter() {
        return null;
    }
}
