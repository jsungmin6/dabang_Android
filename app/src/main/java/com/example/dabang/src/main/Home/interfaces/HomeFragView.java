package com.example.dabang.src.main.Home.interfaces;

import com.example.dabang.src.main.Home.models.HomeInterestRegionResponse;

public interface HomeFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    void gethomeInterestResionSuccess(HomeInterestRegionResponse.HomeInterestRegionResponseResult[] result);

    void validateFailure(String message);

   // void homeRecommendSuccess(ArrayList<postInfo> postList);
}
