package cn.eeepay.app.api;

import cn.eeepay.app.bean.LoginBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xqf on 2017/3/1.
 */

public interface LoginApi {
    @GET("/api/4/news/latest")
    Observable<LoginBean> getIPInfo(@Query("ip") String ip);


}
