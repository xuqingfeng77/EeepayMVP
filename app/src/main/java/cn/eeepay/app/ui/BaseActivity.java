package cn.eeepay.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.eeepay.app.R;
import cn.eeepay.app.presenter.IPresenter;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {
   protected P mPresenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=getmPresenter();
        mUnbinder= ButterKnife.bind(this);
        setContentView(initView());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(mPresenter==null){
            mPresenter=getmPresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        if(mPresenter!=null)
            mPresenter.unsubcrible();
        if(mUnbinder!=null)
            mUnbinder.unbind();
        this.mPresenter=null;
        this.mUnbinder=null;

    }

    protected abstract int initView();//总布局
    protected abstract void initData();//初始化部分数据
    protected abstract P getmPresenter();

}
