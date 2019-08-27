package com.example.akrar.model;

import com.example.akrar.User;
import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("token")
    private String token;
    @SerializedName("user")
    private User user;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
