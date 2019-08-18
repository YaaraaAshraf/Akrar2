package com.example.akrar.products.model;

import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.Responseclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ProductsService {


    @GET("product")
    Call<ResObj<ProductData>> getProducts(@Header("Authorization") String auth);
//                             @Header("national_id") String national_id,
//                             @Header("mobile") String mobile);



}

