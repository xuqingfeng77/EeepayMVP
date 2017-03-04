package cn.eeepay.app.api;

import java.util.List;
import java.util.Map;

import cn.eeepay.app.entity.HttpResult;
import cn.eeepay.app.entity.LoginBean;
import cn.eeepay.app.entity.ParamsInfo;
import cn.eeepay.app.entity.UploadFile;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by xqf on 2017/3/1.
 */

public interface CommonApi {
    /**
     * 传很少参数的get请求
     * @param ip
     * @return
     */
    @GET("/api/4/news/latest")
    Observable<LoginBean> getIPInfo(@Query("ip") String ip);


    //http://ip.taobao.com/service/getIpInfo2.php?ip=myip   这个接口返回的中文是Unicode编码，怎么转码？
    @FormUrlEncoded
    @GET("/service/getIpInfo2.php")
    Observable<LoginBean> logiInfo(@Query("ip") String ip);

    /**
     * @Body: 发送Java对象作为请求体
     * @param params
     * @return
     */
    @GET("/xxx")
    Observable<LoginBean> updateUserInfo(@Body ParamsInfo params);

    /**
     *@Url: 使用动态地址
     * @param url
     * @return
     */
    @GET
    Observable<ResponseBody> getUserName(
            @Url String url
    );

    /**
     * 传递多个相同名字的参数到服务器
     * for example:https://api.example.com/tasks?id=123&id=124&id=125
     * @param taskIds
     * @return
     */
    @GET("/tasks")
    Observable<LoginBean>  getTask(@Query("id") List taskIds);
    /**
     * 上传单个文件
     * @param description
     * @param file
     * @return
     */
//    @Multipart
//    @POST("upload")
//    Observable<ResponseBody> upload(
//            @Part("description") RequestBody description,
//            @Part MultipartBody.Part file
//    );

    /**
     * 单文件上传
     * file:RequestBody名称
     * filename:上传文件名称，可以和真实的文件名称不相同
     * @param file
     * @return
     */
    @POST("/file")   //配置自己的路径
    @Multipart
    Observable<HttpResult<UploadFile>> uploadSingleFile(@Part("file\"; filename=\"avatar.png\"") RequestBody file);

    /**
     * 多文件上传
     * @param params
     * @return
     */
    @Multipart
    @POST("/files")
    Observable<HttpResult<UploadFile>> uploadFiles(@PartMap Map<String, RequestBody> params);

    /**
     * 单文件和其他参数上传
     * @param file
     * @param nickName
     * @return
     */
    @POST("/file")
    @Multipart
    Observable<HttpResult<UploadFile>> uploadSingleFileAndStr(@Part("file\"; filename=\"avatar.png\"") RequestBody file,@Part("nickName") RequestBody nickName);


    /**
     * 多文件上传和其他参数
     * @param params
     * @return
     */
    @Multipart
    @POST("/files")
    Observable<HttpResult<UploadFile>> uploadFilesAndStr(@PartMap Map<String, RequestBody> params,@Part("nickName") RequestBody nickName);

}
