package com.example.akrar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class MyListAdapter_Bond extends RecyclerView.Adapter<MyListAdapter_Bond.ViewHolder> {
    private MyListData_Bond[] listdata_bond;
    public static ArrayList<MyListData_Bond> editModelArrayList;

//
//    public MyListAdapter_Bond(MyListData_Bond[]myListData_bonds){
//        this.listdata_bond =myListData_bonds;
//        inflater = LayoutInflater.from(ctx);
    // RecyclerView recyclerView;
    public MyListAdapter_Bond(MyListData_Bond[] listdata) {
        this.listdata_bond = listdata;
    }

    @NonNull
    @Override
    public MyListAdapter_Bond.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.invoice_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter_Bond.ViewHolder holder, int position) {
        final MyListData_Bond myListData = listdata_bond[position];
        holder.txt_name.setText(listdata_bond[position].getName());
        holder.txt_date.setText(listdata_bond[position].getDate());
        holder.txt_phone.setText(listdata_bond[position].getPhone());
//        holder.txt_date.setText(listdata_bond[position].getDate());
//        holder.txt_phone.setText(listdata_bond[position].getPhone());
    }
    @Override
    public int getItemCount() {
        return listdata_bond.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_date,txt_phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_name=(TextView)itemView.findViewById(R.id.txt_name);
            this.txt_date=(TextView)itemView.findViewById(R.id.txt_date);
            this.txt_phone=(TextView)itemView.findViewById(R.id.txt_national_id);
        }
    }
}



