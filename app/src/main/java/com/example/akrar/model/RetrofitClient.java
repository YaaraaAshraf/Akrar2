package com.example.akrar.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static RetrofitClient minstance;
    public static Retrofit getClient(String url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
    public synchronized RetrofitClient getMinstance(){
        if (minstance==null){
            minstance=new RetrofitClient();
        }
        return minstance;
    }
    public UserService api(){
        return retrofit.create(UserService.class);
    }
}

