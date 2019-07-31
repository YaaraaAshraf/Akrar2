package com.example.akrar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class profileobject {
    @SerializedName("Accept")
    @Expose
    private String accept;
    @SerializedName("Authorization")
    @Expose
    private String auth;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
