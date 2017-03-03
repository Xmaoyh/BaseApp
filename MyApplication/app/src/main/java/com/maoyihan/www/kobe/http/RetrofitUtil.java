package com.maoyihan.www.kobe.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 * Created by Administrator on 2016/9/15.
 */
public class RetrofitUtil {

    public final static String URL = "http://tc.suanzi.cn/Api/";
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
           /* /*//*Request oldRequest = chain.request();
            Request newRequest = oldRequest.newBuilder().header("CONTENT_TYPE", "application/json")
                    .build();
            return chain.proceed(newRequest);*/
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("CONTENT_TYPE", "application/json")
                    .build();
            RequestBody body = request.body();
            return chain.proceed(request);
        }
    }).build();
    //public final String URL="http://baomi.suanzi.cn/Api/";
    private final Retrofit retrofit;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 获取ApiService实例
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        return ApiHolder.retrofitUtil;
    }

    /**
     * ApiService
     *
     * @return
     */
    public <T> T getService(final Class<T> service) {

        return retrofit.create(service);
    }

    static class ApiHolder {
        private static final RetrofitUtil retrofitUtil = new RetrofitUtil();
    }

}
