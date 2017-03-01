package cn.eeepay.app.api;

import cn.eeepay.app.bean.GankData;
import cn.eeepay.app.bean.MeiziData;
import cn.eeepay.app.bean.VedioData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xqf on 2017/3/1.
 */

public interface LoginApi {

    @GET("/api/data/福利/10/{page}")
    Observable<MeiziData> getMeizhiData(@Path("page") int page);

    @GET("/day/{year}/{month}/{day}")
    Observable<GankData> getGankData(@Path("year") int year, @Path("month") int month,
                                     @Path("day") int day);

    @GET("/api/data/休息视频/10/{page}")
    Observable<VedioData> getVedioData(@Path("page") int page);

}
