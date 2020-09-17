package com.example.dabang.src.main.models;

import com.google.gson.annotations.SerializedName;

public class LogInBody {
    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("userPwd")
    private String userPwd;

    public LogInBody(String userEmail, String userPwd) {
        this.userEmail = userEmail;
        this.userPwd = userPwd;
    }
}
