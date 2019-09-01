package com.example.akrar;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.products.model.Product;

import java.util.ArrayList;
import java.util.Calendar;

public class CashListAdapter extends RecyclerView.Adapter<CashListAdapter.ViewHolder> {
    private ArrayList<Rowitem_cash> listdata_cash;
Context context;
    public CashListAdapter(ArrayList<Rowitem_cash> listdata_cash) {
        this.listdata_cash = listdata_cash;
    }

    public void setData(ArrayList<Rowitem_cash> invoices) {
        this.listdata_cash = invoices;
        notifyDataSetChanged();
    }

    public void addPayment(Rowitem_cash payment) {
        this.listdata_cash.add(payment);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CashListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_cash_receipts, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CashListAdapter.ViewHolder holder, int position) {
        final Rowitem_cash myListData = listdata_cash.get(position);
//        holder.edt_payment.setText(listdata_cash.get(position).getPayment());
//        holder.edt_date.setText(listdata_cash.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return listdata_cash.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText edt_payment, edt_date;
        TextView txt_payment, txt_date;
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH)+1;
        final int day = c.get(Calendar.DAY_OF_MONTH);
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.edt_date = (EditText) itemView.findViewById(R.id.edittext_date);
//            edt_date.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    if(event.getAction() == MotionEvent.ACTION_UP) {
//                        if(event.getRawX() <=edt_date.getTotalPaddingLeft()) {
//                            // your action for drawable click event
//                            DatePickerDialog datePicker = new DatePickerDialog(context , new DatePickerDialog.OnDateSetListener() {
//                                @Override
//                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                                    edt_date.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
//                                }
//                            }, year, month, day);
//                            datePicker.setTitle("Choose Date");
//                            datePicker.show();
//                            return true;
//                        }
//                    }
//                    return false;
//                }
//            });

            this.edt_payment = (EditText) itemView.findViewById(R.id.edittext_value);
            this.txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            this.txt_payment = (TextView) itemView.findViewById(R.id.txt_value);

        }
    }
}



