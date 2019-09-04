package com.example.akrar;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvoicepaymentData {

    @SerializedName("financial_payments")
    private List<paymentobject> payment;

//    @SerializedName("paid_payments")
//    private List<paymentobject> paypaymeny;


    public List<paymentobject> getPayment() {
        return payment;
    }

    public void setPayment(List<paymentobject> payment) {
        this.payment = payment;
    }
}


