package com.minhtam.mvpsample.DataManager.Cloud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minhtam.mvpsample.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by st on 1/20/2018.
 */

public class Client {
    private static Retrofit retrofit = null;
    private static Gson gsonRetrofit = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .disableHtmlEscaping()
            .setLenient()
            .create();

    public static Retrofit getClient() {

        if (retrofit == null) {
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(interceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.MAIN_API)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gsonRetrofit))
                    .build();
        }

        return retrofit;
    }

    public static API getAPI(){return Client.getClient().create(API.class);}
}
