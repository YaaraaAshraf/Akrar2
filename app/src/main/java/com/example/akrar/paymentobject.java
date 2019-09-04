package com.example.akrar;

//package com.google.gson.annotations;

///**
// * An annotation that indicates this member should be serialized to JSON with
// * the provided name value as its field name.
// *
// * <p>This annotation will override any {@link com.google.gson.FieldNamingPolicy}, including
// * the default field naming policy, that may have been set on the {@link com.google.gson.Gson}
// * instance.  A different namin


import com.google.gson.annotations.SerializedName;

public class paymentobject {
    @SerializedName("id")
    private String id;
    @SerializedName("financial_invoice_id")
    private String financial_invoice_id;
    @SerializedName("financial_payment_id")
    private String financial_payment_id;
//    @SerializedName("paymentobject")
//    private String payment;
    @SerializedName("date")
    private String date;
    @SerializedName("status")
    private String status;
    @SerializedName("paid")
    private String paid;
    @SerializedName("rest")
    private String rest;


    @SerializedName("paid_payments")
    private paymentobject product;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public paymentobject getProduct() {
        return product;
    }

    public void setProduct(paymentobject product) {
        this.product = product;
    }

    public String getFinancial_invoice_id() {
        return financial_invoice_id;
    }

    public void setFinancial_invoice_id(String financial_invoice_id) {
        this.financial_invoice_id = financial_invoice_id;
    }

    public String getFinancial_payment_id() {
        return financial_payment_id;
    }

    public void setFinancial_payment_id(String financial_payment_id) {
        this.financial_payment_id = financial_payment_id;
    }
}
