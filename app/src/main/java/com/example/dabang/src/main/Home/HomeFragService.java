package com.example.dabang.src.main.Home;

import com.example.dabang.src.main.Home.interfaces.HomeFragView;
import com.example.dabang.src.main.Home.interfaces.HomeRetrofitInterface;
import com.example.dabang.src.main.Home.models.HomeInterestRegionResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dabang.src.ApplicationClass.getRetrofit;

class HomeFragService {
    private final HomeFragView mHomeFragView; //

    HomeFragService(final HomeFragView homeFragView) {
        this.mHomeFragView = homeFragView;
    }

   void getHomeUserInterestRegion(int userIdx) { //서버통신
        //비동기 방식 != 순차적
        final HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
       homeRetrofitInterface.getHomeUserInterestRegion(userIdx).enqueue(new Callback<HomeInterestRegionResponse>() {
            @Override
            public void onResponse(Call<HomeInterestRegionResponse> call, Response<HomeInterestRegionResponse> response) {
                final HomeInterestRegionResponse homeInterestRegionResponse = response.body(); //response:서버에서 받아온 값
                //DefaultResponse는 자동으로 값을 파싱해줌
                if (homeInterestRegionResponse == null) {
                    mHomeFragView.validateFailure(null);
                    return;
                }

                mHomeFragView.gethomeInterestResionSuccess(homeInterestRegionResponse.getResult());
                //mHomeFragView.homeRecommendSuccess(FragHomeResponse.getPostList());
                //성공하면 파싱한 값을 넘겨줌


                //MainActivity에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<HomeInterestRegionResponse> call, Throwable t) { //통신실패
                mHomeFragView.validateFailure(null);
            }
        });
    }
}
