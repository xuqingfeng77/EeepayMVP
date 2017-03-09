package cn.eeepay.app.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.eeepay.app.R;
import cn.eeepay.app.presenter.IPresenter;
import cn.eeepay.app.util.ScreenSwitch;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {
    protected Context mContext;
    protected P mPresenter;
    private Unbinder mUnbinder;
    private Toast mToast;

    protected abstract int initView();//总布局
    protected abstract void initData();//初始化部分数据
    protected abstract P getmPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        mPresenter=getmPresenter();
        setContentView(initView());
        mUnbinder= ButterKnife.bind(this);
        initData();
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
    public void goActivityForResult(Class<?> descClass,int reqCode){
        ScreenSwitch.switchActivity(mContext,descClass,null,reqCode);
    }
    public void goActivityForResult(Class<?> descClass,Bundle bundle,int reqCode){
        ScreenSwitch.switchActivity(mContext,descClass,bundle,reqCode);
    }
    public void goActivity(Class<?> descClass,Bundle bundle){
        goActivityForResult(descClass,bundle,-1);
    }
    public void goActivity(Class<?> descClass){
        goActivity(descClass,null);
    }
    public void showDialog(){
       showT("显示对话框");
    }
    public void showDialog(String msg){
        showDialog();
//        msg
    }
    public void dismissDialog(){
        showT("关闭对话框");
    }
    public void showT(final  String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mToast==null){
                    mToast=Toast.makeText(mContext,text,Toast.LENGTH_LONG);
                }else {
                    mToast.setText(text);
                    mToast.setDuration(Toast.LENGTH_SHORT);
                }
                mToast.show();
            }
        });
    }
    public void cancelT(){
        if(mToast!=null){
            mToast.cancel();
        }
    }




}
