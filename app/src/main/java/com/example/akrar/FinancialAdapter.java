package com.example.akrar;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoiceUser;

import java.util.ArrayList;

public class FinancialAdapter extends RecyclerView.Adapter<FinancialAdapter.ViewHolder> {
    private ArrayList<Invoice> invoices;
    public FinancialAdapter(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }
    public void setData(ArrayList<Invoice> invoices){
        this.invoices = invoices;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FinancialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_financial_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull FinancialAdapter.ViewHolder holder, int position) {
        final Invoice myListData = invoices.get(position);
        holder.txt_name.setText(invoices.get(position).getReceiver().getFirstName());
        holder.txt_date.setText(invoices.get(position).getDate());
        holder.txt_user_id.setText(invoices.get(position).getReceiver().getNationalId());
        if (invoices.get(position).getReceiver().getStatus()==0){
            holder.txt_type.setText("كاش");
        }else {
            holder.txt_type.setText("اجل");
            holder.txt_type.setTextColor(Color.RED);
        }
    }
    @Override
    public int getItemCount() {
        return invoices.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_date,txt_user_id,txt_type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_name=(TextView)itemView.findViewById(R.id.txt_name_fin);
            this.txt_date=(TextView)itemView.findViewById(R.id.text_date);
            this.txt_user_id=(TextView)itemView.findViewById(R.id.txt_user_id);
            this.txt_type=(TextView)itemView.findViewById(R.id.text_type);
        }
    }
}