package com.example.akrar.invoices.model;

import com.example.akrar.model.Currency;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrenciesData {

    @SerializedName("currencies")
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
