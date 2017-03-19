package com.mashazavolnyuk.countries.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mashka on 18.03.17.
 */

public class Retrofit {

    public static final String BASE_URL = "https://restcountries.eu/rest/v2/";
    private static retrofit2.Retrofit retrofit = null;

    private static OkHttpClient.Builder httpClient;
    private static HttpLoggingInterceptor logging;
    private static retrofit2.Retrofit.Builder builder;

    static {
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        httpClient = new OkHttpClient.Builder();

        httpClient.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                final Request original = chain.request();
                // adds "Content-Type" header to all server requests
                final Request request = original.newBuilder().
                        header("Content-Type", "application/json").
                        method(original.method(), original.body()).
                        build();
                return chain.proceed(request);
            }
        }).addInterceptor(logging);

        builder = new retrofit2.Retrofit.Builder().
                baseUrl(BASE_URL).
                client(httpClient.build()).
                addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
    }

    public static retrofit2.Retrofit getRetrofit() {
        return retrofit;
    }
}
