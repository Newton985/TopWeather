package com.example.topweather.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceBuilder {

    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static final OkHttpClient.Builder okHTTPBuilder = new OkHttpClient.Builder().addInterceptor(interceptor);

    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(EndPoints.ACCU_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHTTPBuilder.build());


    public  static <T> T build(Class<T> serviceType){
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceType);
    }

}
