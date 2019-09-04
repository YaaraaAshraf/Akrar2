package com.example.akrar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AmountAdapter extends RecyclerView.Adapter<AmountAdapter.ViewHolder> {

    private ArrayList<paymentobject> amounts;

    public AmountAdapter(ArrayList<paymentobject> amounts) {
        this.amounts = amounts;
    }

    public void setData(ArrayList<paymentobject> invoices){
        this.amounts = invoices;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AmountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.amount_list_item, parent, false);
        AmountAdapter.ViewHolder viewHolder = new AmountAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AmountAdapter.ViewHolder holder, int position) {
        final paymentobject myListData = amounts.get(position);
            holder.txt_amount.setText(holder.txt_amount.getContext().getString(R.string.paymentName, amounts.get(position).getPayment()));
            holder.txt_date.setText(holder.txt_amount.getContext().getString(R.string.payment_number_text, amounts.get(position).getDate()));
//        holder.txt_date.setText(amounts.get(position).getDate());

    }
    @Override
    public int getItemCount() {
        return amounts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_amount, txt_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_amount=(TextView)itemView.findViewById(R.id.txt_amount);
            this.txt_date=itemView.findViewById(R.id.text_date);
        }

    }
}