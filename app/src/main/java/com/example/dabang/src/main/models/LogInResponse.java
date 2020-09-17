package com.example.dabang.src.main.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LogInResponse implements Serializable {


    public class LogInResult implements Serializable {

        @SerializedName("userIdx")
        int userIdx;

        @SerializedName("jwt")
        String jwt;

        public int getUserIdx() {
            return userIdx;
        }

        public String getJwt() {
            return jwt;
        }
    }

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private LogInResult result;

    public LogInResult getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}