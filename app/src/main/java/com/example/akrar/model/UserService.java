package com.example.akrar.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @FormUrlEncoded
    @POST("login")
    Call<ResObj> login(@Field("email") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<Responseclass> createuser(@Field("firstname") String firstname,
                            @Field("lastname") String lastname,
                            @Field("email") String email,
                            @Field("phone") String phone,
                            @Field("password") String password,
                            @Field("password_confirmation") String password_confirmation);



}
