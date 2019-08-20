package com.example.akrar.model;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.products.model.ProductsService;

import retrofit2.Retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://ekrar.otexdemos.com/api/";
    private static RetrofitClient minstance;
    private Retrofit retrofit;

    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }

    public static ProductsService getProductsService() {
        return RetrofitClient.getClient(BASE_URL).create(ProductsService.class);
    }


    public static InvoicesService getInvoicesService() {
        return RetrofitClient.getClient(BASE_URL).create(InvoicesService.class);
    }


}
