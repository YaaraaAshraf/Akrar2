package com.example.akrar;

import com.example.akrar.products.model.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationData {

    @SerializedName("notifications")
    private List<NotificationObject> products;

    public List<NotificationObject> getProducts() {
        return products;
    }

    public void setProducts(List<NotificationObject> products) {
        this.products = products;
    }
}
