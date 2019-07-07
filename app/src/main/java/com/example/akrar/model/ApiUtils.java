package com.example.akrar.model;

import retrofit2.Retrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://138.68.30.65/ekrar/public/api/";
    private static RetrofitClient minstance;
    private Retrofit retrofit;
    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}