package com.example.dabang.src.main.interfaces;

import com.example.dabang.src.main.models.DefaultResponse;
import com.example.dabang.src.main.models.LogInBody;
import com.example.dabang.src.main.models.LogInResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MainRetrofitInterface {
//    @GET("/test")
    @GET("/jwt")
    Call<DefaultResponse> getTest();

    @GET("/users/{userIdx}/interest-regions")
    Call<DefaultResponse> getTestPathAndQuery(
            @Path("userIdx") int number,
            @Query("content") final String content
    );

    @POST("/users/login")
    Call<LogInResponse> logInTest(@Body LogInBody params);
}
