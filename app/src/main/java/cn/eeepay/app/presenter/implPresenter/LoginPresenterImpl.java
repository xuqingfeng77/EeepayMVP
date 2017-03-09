package cn.eeepay.app.presenter.implPresenter;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cn.eeepay.app.api.ApiManager;
import cn.eeepay.app.api.CommonApi;
import cn.eeepay.app.entity.HttpResult;
import cn.eeepay.app.entity.LoginBean;
import cn.eeepay.app.entity.UploadFile;
import cn.eeepay.app.presenter.ILoginPresenter;
import cn.eeepay.app.presenter.view.ILoginView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xqf on 2017/3/2.
 * 登录逻辑实现类，涉及到view展示类的就不在这里写，都是通过回调反馈到view层
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
        Subscription subscription = ApiManager.createService(CommonApi.class,null).logiInfo("myip")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new
                        Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {
//                        mLoginView.setName("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mLoginView.setName(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                         mLoginView.setName(loginBean.getStories().get(0).getTitle());
                    }
                });
        addSubscription(subscription);
//        subscription.unsubscribe();//取消订阅

    }

    @Override
    public void uploadSignleFile() {
        File file=new File("xxxxx");//test  图片地址
        //创建RequwstBody对象

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        //创建nickNameBody对象
        RequestBody nickNameBody = RequestBody.create(MediaType.parse("text/plain"), "xqf");

        Subscription subscription = ApiManager.createService(CommonApi.class,null).uploadSingleFileAndStr(requestBody,nickNameBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<HttpResult<UploadFile>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(HttpResult<UploadFile> uploadFile) {
                    }
                });
        addSubscription(subscription);
    }

    @Override
    public void uploadMoreFile() {

        //组装partMap对象
        Map<String, RequestBody> partMap = new HashMap<>();
//        for(File file : files ){//用的时候把这里放开
//            RequestBody fileBody = RequestBody.create(MediaType.parse("image/*"), file);
//            partMap.put("file\"; filename=\""+file.getName()+"\"", fileBody);
//        }
        //创建nickNameBody对象
        RequestBody nickNameBody = RequestBody.create(MediaType.parse("text/plain"), "xqf");//传其他参数时

        Subscription subscription = ApiManager.createService(CommonApi.class,null).uploadFiles(partMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<HttpResult<UploadFile>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(HttpResult<UploadFile> uploadFile) {
                    }
                });
        addSubscription(subscription);

    }
}
