package com.drteam.gifsemoji.API;

import com.drteam.gifsemoji.Constants;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CUONG-PH on 4/10/2017.
 */

public class GifsApi {

    private static Retrofit mRetrofitCore;
    private static GifsServices services;

    static OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build();
    public static GifsServices getCoreServices() {
        if (mRetrofitCore == null) {
            mRetrofitCore = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        services = mRetrofitCore.create(GifsServices.class);
        return services;
    }
}
