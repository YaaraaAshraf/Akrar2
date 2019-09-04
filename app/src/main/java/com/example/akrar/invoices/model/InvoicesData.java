package com.example.akrar.invoices.model;

import com.example.akrar.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InvoicesData {

    @SerializedName("invoices_sent")
    private List<Invoice> invoicesSent;

    @SerializedName("invoices_recieved")
    private List<Invoice> invoicesRecieved;

    @SerializedName("shipment_invoices")
    private List<Invoice> shipmentInvoices;

    public List<Invoice> getInvoicesSent() {
        return invoicesSent;
    }

    public void setInvoicesSent(List<Invoice> invoicesSent) {
        this.invoicesSent = invoicesSent;
    }

    public List<Invoice> getInvoicesRecieved() {
        return invoicesRecieved;
    }

    public void setInvoicesRecieved(List<Invoice> invoicesRecieved) {
        this.invoicesRecieved = invoicesRecieved;
    }

    public List<Invoice> getShipmentInvoices() {
        return shipmentInvoices;
    }

    public void setShipmentInvoices(List<Invoice> shipmentInvoices) {
        this.shipmentInvoices = shipmentInvoices;
    }
}
