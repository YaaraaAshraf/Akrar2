package com.example.akrar.invoices;

import com.example.akrar.invoices.model.CurrenciesData;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoiceDetailsData;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.ProductData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InvoicesService {

    @GET("index_shipment_invoice")
    Call<ResObj<InvoicesData>> listInvoices(@Header("Authorization") String auth);

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

    @FormUrlEncoded
    @POST("add_shipment_invoice")
    Call<ResObj> addShipmentInvoice(@Header("Authorization") String auth,
                                    @Field("national_id") String national_id,
                                    @Field("currency_id") String currency_id,
                                    @Field("address") String address,
                                    @Field("description") String description,
                                    @Field("total") String total);

    @GET("currency")
    Call<ResObj<CurrenciesData>> listCurrencies(@Header("Authorization") String auth);

    @GET("show_financial_invoice/5")
    Call<ResObj<InvoicesData>> showfinancialpayment(@Header("Authorization") String auth);
}

