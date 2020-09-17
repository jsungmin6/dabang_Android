package com.example.dabang.src.main.Home.models;

import com.google.gson.annotations.SerializedName;

public class HomeInterestRegionResponse {

    public class HomeInterestRegionResponseResult {
        @SerializedName("regionName")
        private String regionName;

        @SerializedName("roomNum")
        private String roomNum;

        @SerializedName("regionImg")
        private String regionImg;

        @SerializedName("roomType")
        private String roomType;

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

        public String getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(String roomNum) {
            this.roomNum = roomNum;
        }

        public String getRegionImg() {
            return regionImg;
        }

        public void setRegionImg(String regionImg) {
            this.regionImg = regionImg;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }
    }

    @SerializedName("code") //서버에서 받아온 response를 자동으로 파싱해줌
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private HomeInterestRegionResponse.HomeInterestRegionResponseResult[] result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public HomeInterestRegionResponseResult[] getResult() {
        return result;
    }
}