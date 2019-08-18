package com.example.akrar.model;
import com.example.akrar.login_and_registration.model.LoginData;

import retrofit2.Call;
import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.Header;
        import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("login")
    Call<ResObj<LoginData>> login(@Field("national_id") String national_id,

                                  @Field("password") String password);

//                       @Field("password") String password);


    @FormUrlEncoded
    @POST("register")
    Call<Responseclass> createuser(@Field("firstname") String firstname,
                                   @Field("lastname") String lastname,
                                   @Field("national_id") String national_id,
                                   @Field("email") String email,
                                   @Field("mobile") String mobile,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String password_confirmation);



    @GET("profile")
    Call<ResObj<LoginData>> user(@Header("Authorization") String auth);
//                             @Header("national_id") String national_id,
//                             @Header("mobile") String mobile);


    
    @POST("edit_profile")
    Call<Responseclass> editprofile(@Field("firstname") String firstname,
                                   @Field("lastname") String lastname,
                                   @Field("national_id") String national_id,
                                   @Field("email") String email,
                                   @Field("mobile") String mobile,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String password_confirmation);
//    Call<ResObj<LoginData>> userupdate(@Header("Authorization") String auth);
}

