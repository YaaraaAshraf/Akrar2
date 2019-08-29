package com.example.akrar.invoices.model;

import com.example.akrar.products.model.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvoiceDetailsData {

    @SerializedName("shipment_invoice")
    private Invoice shipmentInvoice;
    @SerializedName("financial_invoice")
    private Invoice financialInvoice;
    @SerializedName("shipment_products")
    private List<Product> products;
    @SerializedName("products")
    private List<Product> financialProducts;

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


    public Invoice getFinancialInvoice() {
        return financialInvoice;
    }

    public void setFinancialInvoice(Invoice financialInvoice) {
        this.financialInvoice = financialInvoice;
    }

    public List<Product> getFinancialProducts() {
        return financialProducts;
    }

    public void setFinancialProducts(List<Product> financialProducts) {
        this.financialProducts = financialProducts;
    }
}
