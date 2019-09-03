package com.example.akrar.invoices;

import com.example.akrar.invoices.model.CurrenciesData;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoiceDetailsData;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.Product;
import com.example.akrar.products.model.ProductData;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface InvoicesService {

    @GET("index_shipment_invoice")
    Call<ResObj<InvoicesData>> listInvoices(@Header("Authorization") String auth);

    @FormUrlEncoded
    @POST("filter_shipment_invoice")
    Call<ResObj<InvoicesData>> filterInvoices(@Header("Authorization") String auth,
                                              @Field ("status") String status,
                                              @Field ("national_id") String nationalID,
                                              @Field ("from") String from,
                                              @Field ("to") String to);

    @FormUrlEncoded
    @POST("filter_financial_invoice")
    Call<ResObj<InvoicesData>> filterFinancialInvoices(@Header("Authorization") String auth,
                                              @Field ("status") String status,
                                              @Field ("national_id") String nationalID,
                                              @Field ("from") String from,
                                              @Field ("pay_type") String paytype,
                                              @Field ("to") String to);

    @GET("show_shipment_invoice/{index}")
    Call<ResObj<InvoiceDetailsData>> getInvoiceDetails(@Header("Authorization") String auth, @Path("index") long id);

    @GET("show_financial_invoice/{index}")
    Call<ResObj<InvoiceDetailsData>> getInvoiceFinancialDetails(@Header("Authorization") String auth, @Path("index") long id);

    @GET("index_financial_invoice")
    Call<ResObj<InvoicesData>> listFinancialInvoices(@Header("Authorization") String auth);

    @FormUrlEncoded
    @POST("add_financial_invoice")
    Call<ResObj> add_financial_invoice(@Header("Authorization") String auth,
                                       @Field("shipment_invoice_id") String invoice_id);

//
//    @FormUrlEncoded
//    @POST("filter_shipment_invoice")
//    Call<ResObj> filterinvoice(@Header("Authorization") String auth,
//                                        @Field("national_id") String invoice_id,
//                                        @Field("from") String datefrom,
//                                        @Field("to") String dateto);


    @FormUrlEncoded
    @POST("add_shipment_invoice")
    Call<ResObj> addShipmentInvoice(@Header("Authorization") String auth,
                                    @Field(value = "national_id",encoded = true) String national_id,
                                    @Field(value = "currency_id",encoded = true) String currency_id,
                                    @Field(value = "address",encoded = true) String address,
                                    @Field(value = "description",encoded = true) String description,
                                    @Field(value = "total",encoded = true) String total,
                                    @FieldMap Map<String,String> products);

    @GET("currency")
    Call<ResObj<CurrenciesData>> listCurrencies(@Header("Authorization") String auth);

    @GET("notification")
    Call<ResObj>getNotification(@Header("Authorization") String auth);

    @GET("show_financial_invoice/5")
    Call<ResObj<InvoicesData>> showfinancialpayment(@Header("Authorization") String auth);
}

