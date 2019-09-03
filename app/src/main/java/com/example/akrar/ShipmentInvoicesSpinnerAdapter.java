package com.example.akrar;

import android.content.Context;

import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.model.Currency;

import java.util.List;

public class ShipmentInvoicesSpinnerAdapter extends SpinnerAdapter<Invoice> {

    public ShipmentInvoicesSpinnerAdapter(Context context, int resource, List data, String defaultValueTitle) {
        super(context, resource, data, defaultValueTitle);
    }

    public ShipmentInvoicesSpinnerAdapter(Context context, int resource, String defaultValueTitle) {
        super(context, resource, defaultValueTitle);
    }

    @Override
    protected String getTitle(int position) {
        if(mData.get(position).getSender() !=null)
            return "من: "+mData.get(position).getSender().getFirstName()+"\n"+"الهوية: "+mData.get(position).getSender().getNationalId()
                    +"\n"+"التاريخ: "+mData.get(position).getCreatedAt();
        else
            return "إلى: "+mData.get(position).getReceiver().getFirstName()+"\n"+"الهوية: "+mData.get(position).getReceiver().getNationalId()
                    +"\n"+"التاريخ: "+mData.get(position).getCreatedAt();
    }

    @Override
    public List<Invoice> getData() {
        return super.getData();
    }
}
