package com.example.dabang.src.main;

import com.example.dabang.src.main.interfaces.MainActivityView;
import com.example.dabang.src.main.interfaces.MainRetrofitInterface;
import com.example.dabang.src.main.models.DefaultResponse;
import com.example.dabang.src.main.models.LogInBody;
import com.example.dabang.src.main.models.LogInResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dabang.src.ApplicationClass.getRetrofit;

class MainService {
    private final MainActivityView mMainActivityView;

    MainService(final MainActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }



    void postLogIn(String userEmail, String userPwd) {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.logInTest(new LogInBody(userEmail,userPwd)).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                final LogInResponse logInResponse = response.body();
                if (logInResponse == null) {
                    mMainActivityView.validateFailure(null);
                    return;
                }

                mMainActivityView.LogInSuccess(logInResponse.getResult());
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
            }
        });
    }


    public void getTest() {
    }
}
