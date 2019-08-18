package com.example.akrar.products.model;

import com.example.akrar.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductData {

    @SerializedName("products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
