package cjx.com.diary.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: bear
 * @Description: HttpServer
 * @date: 2017/5/10
 */

public class ApiService {
    private HttpInterface mHttpInterface;

    //获取单例
    public static HttpInterface getApiService() {
        return getInstance().mHttpInterface;
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final ApiService INSTANCE = new ApiService();
    }

    private static ApiService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private ApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mHttpInterface = retrofit.create(HttpInterface.class);
    }

    private final String BASE_URL = "http://192.168.40.137:1377";
}
