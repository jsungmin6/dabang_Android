package com.example.dabang.src.main.Home.interfaces;

import com.example.dabang.src.main.Home.models.HomeInterestRegionResponse;
import com.example.dabang.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeRetrofitInterface {

    @GET("/users/{userIdx}/interest-regions")
    Call<HomeInterestRegionResponse> getHomeUserInterestRegion(
            @Path("userIdx") int userIdx
    );
//
//    @POST("/test")
//    Call<DefaultResponse> postTest(@Body RequestBody params);
}
