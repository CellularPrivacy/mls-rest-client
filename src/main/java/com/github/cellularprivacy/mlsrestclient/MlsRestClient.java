package com.github.cellularprivacy.mlsrestclient;

import com.github.cellularprivacy.mlsrestclient.service.MlsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Date;

@SuppressWarnings("unused")
public class MlsRestClient {

    private final Retrofit retrofit;
    private final Gson gson;

    public MlsRestClient(String apiKey) {
        this(new OkHttpClient.Builder(), apiKey);
    }

    public MlsRestClient(OkHttpClient okHttpClient, String apiKey) {
        this(okHttpClient.newBuilder(), apiKey);
    }

    public MlsRestClient(OkHttpClient.Builder okHttpClient, final String apiKey) {

        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("key", apiKey)
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url)
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTypeAdapter().nullSafe())
                .create();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl("https://location.services.mozilla.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    WeakReference<MlsService> mlsServiceWeakReference;

    public MlsService getService() {
        if (mlsServiceWeakReference == null || mlsServiceWeakReference.get() == null) {
            mlsServiceWeakReference = new WeakReference<MlsService>(retrofit.create(MlsService.class));
        }

        return mlsServiceWeakReference.get();
    }

    public Gson getGson() {
        return gson;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private static class DateTypeAdapter extends TypeAdapter<Date> {
        @Override
        public void write(JsonWriter out, Date value) throws IOException {
            out.value(value.getTime());
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            return new Date(in.nextLong());
        }
    }
}
