package com.example.akrar.model;
import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.Header;
        import retrofit2.http.POST;
        import retrofit2.http.Path;
public interface UserService {
    @FormUrlEncoded
    @POST("login")
    Call<ResObj<LoginData>> login(@Field("national_id") String national_id,
                                  @Field("password") String password,
                                  @Field("device_id") String deviceId);

//                       @Field("password") String password);


    @FormUrlEncoded
    @POST("register")
    Call<ResObj<LoginData>> createuser(@Field("first_name") String firstname,
                                   @Field("last_name") String lastname,
                                   @Field("national_id") String national_id,
                                   @Field("email") String email,
                                   @Field("mobile") String mobile,
                                   @Field("password") String password,
                                   @Field("password_confirmation") String password_confirmation,
                                   @Field("device_id") String deviceId);



    @GET("profile")
    Call<ResObj<LoginData>> user(@Header("Authorization") String auth);
//                             @Header("national_id") String national_id,
//                             @Header("mobile") String mobile);


@POST("logout")
Call<ResObj> logout(@Header("Authorization") String auth);
    //                        @Field("") String lastname);
    @FormUrlEncoded
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

//    @FormUrlEncoded
//    @POST("add_paid_payment/{index}")
//    Call<ResObj> addPayment(@Header("Authorization") String auth,