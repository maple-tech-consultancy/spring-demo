package com.demo.demo;

public class UserAddressModel {
    private String userID;
    private String userAddress;

    public UserAddressModel(String userID, String userAddress) {
        this.userID = userID;
        this.userAddress = userAddress;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
