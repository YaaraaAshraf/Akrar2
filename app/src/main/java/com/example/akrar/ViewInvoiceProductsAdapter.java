package com.example.akrar;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.akrar.products.model.Product;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewInvoiceProductsAdapter extends RecyclerView.Adapter<ViewInvoiceProductsAdapter.ViewHolder> {
    private ArrayList<Product> products;

    public ViewInvoiceProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public void setData(ArrayList<Product> invoices){
        this.products = invoices;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewInvoiceProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.view_product_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewInvoiceProductsAdapter.ViewHolder holder, int position) {
//        final Product myListData = products.get(position);

        holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.productName,products.get(position).getProduct().getName()));
        holder.txt_price.setText(holder.txt_name.getContext().getString(R.string.price,products.get(position).getPrice()));
        holder.txt_unit.setText(holder.txt_name.getContext().getString(R.string.unit,products.get(position).getUnits()));
        holder.txt_amount.setText(holder.txt_name.getContext().getString(R.string.amount,products.get(position).getQuantity()));
        holder.productToggle.setTextOn(holder.txt_name.getContext().getString(R.string.product_number,position+1));
        holder.productToggle.setTextOff(holder.txt_name.getContext().getString(R.string.product_number,position+1));
        holder.productToggle.setText(holder.txt_name.getContext().getString(R.string.product_number,position+1));
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
//        CardView card_view;
        ToggleButton productToggle;
        TextView txt_name,txt_amount,txt_unit, txt_price;
        LinearLayout product_layout;
//        CircleImageView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productToggle=itemView.findViewById(R.id.product_toggle);
            this.product_layout=itemView.findViewById(R.id.product_sub_layout);
            this.productToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    product_layout.setVisibility(isChecked?View.VISIBLE:View.GONE);
                }
            });
            this.txt_name=(TextView)itemView.findViewById(R.id.product_name_text_view);

            this.txt_amount=(TextView)itemView.findViewById(R.id.amount_text_view);
            this.txt_unit=itemView.findViewById(R.id.unit_text_view);
            this.txt_price=itemView.findViewById(R.id.price_text_view);
        }

    }
}



