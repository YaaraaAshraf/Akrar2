package com.example.akrar.model;

public class ApiUtils {

    public static final String BASE_URL = "http://138.68.30.65/ekrar/public/api/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}