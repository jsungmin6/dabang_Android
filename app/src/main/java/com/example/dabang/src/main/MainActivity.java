package com.example.dabang.src.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dabang.R;
import com.example.dabang.src.BaseActivity;
import com.example.dabang.src.main.Home.HomeFragment;
import com.example.dabang.src.main.interfaces.MainActivityView;
import com.example.dabang.src.main.models.LogInResponse;

import static com.example.dabang.src.ApplicationClass.sSharedPreferences;
import static com.example.dabang.src.ApplicationClass.X_ACCESS_TOKEN;
public class MainActivity extends BaseActivity implements MainActivityView {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFragment home;
    private MainService mainService;

    SharedPreferences.Editor preferencesEditor = sSharedPreferences.edit();
    String jwt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void tryGetTest() {
        showProgressDialog();

        mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void LogInSuccess(LogInResponse.LogInResult result) {
        hideProgressDialog();
        jwt = result.getJwt();
        preferencesEditor.putString(X_ACCESS_TOKEN,jwt);
    }




//    public void customOnClick(View view) {
//        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
//            default:
//                break;
//        }
//    }
}
