package com.example.akrar.invoices;

import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.ProductData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface InvoicesService {

    @GET("index_shipment_invoice")
    Call<ResObj<InvoicesData>> listInvoices(@Header("Authorization") String auth);


//    @FormUrlEncoded
//    @POST("add_product")
//    Call<ResObj> addProduct(@Header("Authorization") String auth, @Field("name") String name);

}

