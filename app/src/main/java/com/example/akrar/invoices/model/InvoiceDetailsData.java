package com.example.akrar.invoices.model;

import com.example.akrar.products.model.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvoiceDetailsData {

    @SerializedName("shipment_invoice")
    private Invoice shipmentInvoice;

    @SerializedName("shipment_products")
    private List<Product> products;

    public Invoice getShipmentInvoice() {
        return shipmentInvoice;
    }

    public void setShipmentInvoice(Invoice shipmentInvoice) {
        this.shipmentInvoice = shipmentInvoice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
