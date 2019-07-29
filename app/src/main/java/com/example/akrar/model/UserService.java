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
    Call<ResObj> login(@Field("national_id") String national_id,
                       @Field("password") String password);


    @FormUrlEncoded
    @POST("register")
    Call<Responseclass> createuser(@Field("firstname") String firstname,
                                   @Field("lastname") String lastname,
                                   @Field("national_id") String national_id,
                                   @Field("email") String email,
                                   @Field("mobile") String mobile,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String password_confirmation);


    @FormUrlEncoded
    @GET("profile")
    Call<Responseclass> User(@Field("firstname") String firstname,
                                   @Field("lastname") String lastname,
                                   @Field("national_id") String national_id,
//                                   @Field("email") String email,
                                   @Field("mobile") String mobile,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String password_confirmation);

}
