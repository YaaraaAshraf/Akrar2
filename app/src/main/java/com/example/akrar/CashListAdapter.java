package com.example.akrar;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.akrar.invoices.model.Invoice;

import java.util.ArrayList;
public class CashListAdapter extends RecyclerView.Adapter<CashListAdapter.ViewHolder> {
    private ArrayList<Rowitem_cash> listdata_cash;
    public CashListAdapter(ArrayList<Rowitem_cash>listdata_cash) {
        this.listdata_cash = listdata_cash;
    }
    @NonNull
    @Override
    public CashListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_cash_receipts, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull CashListAdapter.ViewHolder holder, int position) {
        final Rowitem_cash myListData = listdata_cash.get(position);
        holder.edt_payment.setText(listdata_cash.get(position).getPayment());
        holder.edt_date.setText(listdata_cash.get(position).getDate());

    }
    @Override
    public int getItemCount() {
        return listdata_cash.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText edt_payment,edt_date;
        TextView txt_payment,txt_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.edt_payment=(EditText) itemView.findViewById(R.id.editText_date);
            this.txt_date=(EditText) itemView.findViewById(R.id.edit_value);
            this.txt_date=(TextView) itemView.findViewById(R.id.txt_date);
            this.txt_payment=(TextView) itemView.findViewById(R.id.txt_value);

        }
    }
}



