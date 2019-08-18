package com.example.akrar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.akrar.invoices.model.Invoice;

import java.util.ArrayList;

public class InvoicesAdapter extends RecyclerView.Adapter<InvoicesAdapter.ViewHolder> {
    private ArrayList<Invoice> invoices;

    public InvoicesAdapter(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void setData(ArrayList<Invoice> invoices){
        this.invoices = invoices;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InvoicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.invoice_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InvoicesAdapter.ViewHolder holder, int position) {
        final Invoice myListData = invoices.get(position);
        holder.txt_name.setText(invoices.get(position).getAddress());
        holder.txt_date.setText(invoices.get(position).getDate());
//        holder.txt_phone.setText(invoices.get(position).getId());
//        holder.txt_date.setText(invoices[position].getDate());
//        holder.txt_phone.setText(invoices[position].getPhone());
    }
    @Override
    public int getItemCount() {
        return invoices.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_date,txt_phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_name=(TextView)itemView.findViewById(R.id.txt_name);
            this.txt_date=(TextView)itemView.findViewById(R.id.txt_date);
            this.txt_phone=(TextView)itemView.findViewById(R.id.txt_phone);
        }
    }
}



