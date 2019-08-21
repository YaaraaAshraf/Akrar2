package com.example.akrar.invoices;

import com.example.akrar.invoices.model.CurrenciesData;
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

    @GET("index_financial_invoice")
    Call<ResObj<InvoicesData>> listFinancialInvoices(@Header("Authorization") String auth);

    @FormUrlEncoded
    @POST("add_financial_invoice")
    Call<ResObj> add_financial_invoice (@Header("Authorization") String auth,
                            @Field("shipment_invoice_id") String invoice_id,
                            @Field("pay_type") String pay_type);
//                            @Field("description") String desc,
//                            @Field("date") String date,
//                            @Field("payment") String payment);


    @GET("currency")
    Call<ResObj<CurrenciesData>> listCurrencies(@Header("Authorization") String auth);

}

