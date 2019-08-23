package com.example.handi.cross.api;

import com.example.handi.cross.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by handi.imsi on 21/08/2019.
 */

public class RetrofitClientInstance {

    private static Retrofit retrofit;


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.readTimeout(60, TimeUnit.SECONDS);
            client.writeTimeout(60, TimeUnit.SECONDS);
            client.connectTimeout(60, TimeUnit.SECONDS);
            client.addInterceptor(interceptor);
            client.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();

                    return chain.proceed(request);
                }
            });


            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}