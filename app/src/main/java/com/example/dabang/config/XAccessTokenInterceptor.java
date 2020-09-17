package com.example.dabang.config;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.dabang.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.dabang.src.ApplicationClass.sSharedPreferences;

public class XAccessTokenInterceptor implements Interceptor {

    @Override
    @NonNull
    public Response intercept(@NonNull final Interceptor.Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);

        //실제로는 이거 지워야함
        sSharedPreferences.edit().putString(X_ACCESS_TOKEN, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRlIjoiMjAyMC0wNy0yMiAwNDowMDowMiIsInVzZXJJZHgiOiIyIiwidXNlckVtYWlsIjoianN1bmdtaW41MDZAZ21haWwuY29tIn0.wfTK797AmaraLqPGCr9GhG-37DBa0v51tKUal2HDmfQ").apply();
        if (jwtToken != null) {
            builder.addHeader("X-ACCESS-TOKEN", jwtToken);
        }
        return chain.proceed(builder.build());
    }
}
