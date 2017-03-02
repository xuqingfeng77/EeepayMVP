package cn.eeepay.app.api;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xqf on 2017/3/1.
 */

public class ApiManager {
    public static  String apiBaseUrl="http://github.com";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(apiBaseUrl)
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

            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

    /**
     * 更换url，再去createService
     * @param newApiBaseUrl
     */
    public static void changeApiBaseUrl(String newApiBaseUrl) {
        apiBaseUrl = newApiBaseUrl;
        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())//用gson解析
                .baseUrl(apiBaseUrl);
    }

}
