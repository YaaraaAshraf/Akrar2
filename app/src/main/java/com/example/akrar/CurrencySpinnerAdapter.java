package com.example.akrar;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.akrar.model.Currency;

import java.util.List;

public class CurrencySpinnerAdapter extends SpinnerAdapter<Currency> {

    public CurrencySpinnerAdapter(Context context, int resource, List data, String defaultValueTitle) {
        super(context, resource, data, defaultValueTitle);
    }

    public CurrencySpinnerAdapter(Context context, int resource, String defaultValueTitle) {
        super(context, resource, defaultValueTitle);
    }

    @Override
    protected String getTitle(int position) {
        return mData.get(position).getName();
    }

    @Override
    public List<Currency> getData() {
        return super.getData();
    }
}
