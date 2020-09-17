package com.example.dabang.src.main.interfaces;

import com.example.dabang.src.main.models.LogInResponse;

public interface MainActivityView {

    void validateSuccess(String text);

    void validateFailure(String message);

    void LogInSuccess(LogInResponse.LogInResult result);
}
