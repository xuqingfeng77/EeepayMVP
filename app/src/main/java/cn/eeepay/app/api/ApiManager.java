package cn.eeepay.app.api;


import java.util.concurrent.TimeUnit;

import cn.eeepay.app.entity.HttpResult;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.functions.Func1;

/**
 * Created by xqf on 2017/3/1.
 */

public class ApiManager {
    public static  String apiBaseUrl="http://news-at.zhihu.com/";
//    public static  String apiBaseUrl="http://ip.taobao.com/";
    private static Retrofit retrofit;
    private static final int DEFAULT_TIMEOUT = 5;
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(apiBaseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());//用gson解析

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();
    public static <S> S createService(
            Class<S> serviceClass, final Interceptor credentials) {
        if (credentials != null) {
//            HawkAuthenticationInterceptor interceptor =
//                    new HawkAuthenticationInterceptor(credentials);
//            if (!httpClient.interceptors().contains(interceptor)) {
//                httpClient.addInterceptor(interceptor);
//                builder.client(httpClient.build());
//                retrofit = builder.build();
//            }
        }
        httpClient.connectTimeout(30,TimeUnit.SECONDS);
        builder.client(httpClient.build());
        retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * 更换url，再去createService
     * @param newApiBaseUrl
     */
    public static void changeApiBaseUrl(String newApiBaseUrl) {
        apiBaseUrl = newApiBaseUrl;
        builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())//用gson解析
                .baseUrl(apiBaseUrl);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
     class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getErrorCode() == 0) {
                throw new ApiException(100);
            }
            return httpResult.getSubjects();
        }
    }

}
