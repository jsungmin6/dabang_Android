package com.example.dabang.src.main.Home.models;

public class HomeInterestRegionItem {
    private String regionName;
    private String roomNum;
    private String regionImg;
    private String roomType;


    public HomeInterestRegionItem(String regionName, String roomNum, String regionImg, String roomType) {
        this.regionName = regionName;
        this.roomNum = roomNum;
        this.regionImg = regionImg;
        this.roomType = roomType;
    }



    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setRegionImg(String regionImg) {
        this.regionImg = regionImg;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getRegionImg() {
        return regionImg;
    }

    public String getRoomType() {
        return roomType;
    }
}
