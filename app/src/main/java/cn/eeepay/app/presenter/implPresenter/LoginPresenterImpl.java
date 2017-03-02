package cn.eeepay.app.presenter.implPresenter;

import android.content.Context;
import android.util.Log;

import cn.eeepay.app.api.ApiManager;
import cn.eeepay.app.api.LoginApi;
import cn.eeepay.app.bean.LoginBean;
import cn.eeepay.app.presenter.ILoginPresenter;
import cn.eeepay.app.presenter.view.ILoginView;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xqf on 2017/3/2.
 * 登录逻辑实现类
 */

public class LoginPresenterImpl extends BasePresenterImpl implements ILoginPresenter {
     String TAG=this.getClass().getName();
    ILoginView mLoginView;

    //构造方法
    public LoginPresenterImpl(Context context,ILoginView view){
        mContext=context;
        mLoginView=view;
    }

    @Override
    public void getVedioData(int t) {

    }

    @Override
    public void getMeiziData(int t) {
        Log.d(TAG,"接受到的数据="+t);
        Subscription subscription = ApiManager.createService(LoginApi.class,null).getIPInfo("22")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                         mLoginView.setName(loginBean.getStories().get(0).getTitle());
                    }
                });
        addSubscription(subscription);


    }
}
