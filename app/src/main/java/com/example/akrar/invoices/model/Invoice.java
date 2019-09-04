package com.example.akrar.invoices.model;

import com.example.akrar.model.Currency;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Invoice implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("sender_id")
    private int senderId;

    @SerializedName("receiver_id")
    private int receiverId;

    @SerializedName("currency_id")
    private int currencyId;

    @SerializedName("description")
    private String description;

    @SerializedName("address")
    private String address;

    @SerializedName("date")
    private String date;

    @SerializedName("total")
    private String total;

    @SerializedName("confirmed")
    private int confirmed;

    @SerializedName("status")
    private int status;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("receiver")
    private InvoiceUser receiver;

    @SerializedName("sender")
    private InvoiceUser sender;

    @SerializedName("currency")
    private Currency currency;

    @SerializedName("shipment_invoice")
    private Invoice shipmentInvoice;

    @SerializedName("financial_invoice")
    private Invoice financialInvoice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public InvoiceUser getReceiver() {
        return receiver;
    }
    public InvoiceUser getSender() {
        return sender;
    }
    public void setSender(InvoiceUser sender) {
        this.sender = receiver;
    }
    public void setReceiver(InvoiceUser receiver) {
        this.receiver = receiver;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    public Invoice getShipmentInvoice() {
        return shipmentInvoice;
    }

    public void setShipmentInvoice(Invoice shipmentInvoice) {
        this.shipmentInvoice = shipmentInvoice;
    }

    public Invoice getFinancialInvoice() {
        return financialInvoice;
    }

    public void setFinancialInvoice(Invoice financialInvoice) {
        this.financialInvoice = financialInvoice;
    }
}
