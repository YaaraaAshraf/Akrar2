package com.example.akrar;

import android.support.annotation.NonNull;
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

public class AddInvoiceProductsAdapter extends RecyclerView.Adapter<AddInvoiceProductsAdapter.ViewHolder> {
    private ArrayList<Product> products;

    public AddInvoiceProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public void setData(ArrayList<Product> invoices){
        this.products = invoices;
        notifyDataSetChanged();
    }

    public void addProduct(Product product){
        this.products.add(product);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AddInvoiceProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.add_invoice_product_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull AddInvoiceProductsAdapter.ViewHolder holder, int position) {
//        final Product myListData = products.get(position);
//        holder.edit_text_product.setText(holder.edit_text_product.getContext().getString(R.string.productName,products.get(position).getProduct().getName()));
//        holder.txt_price.setText(holder.edit_text_product.getContext().getString(R.string.price,products.get(position).getPrice()));
//        holder.text_unit.setText(holder.edit_text_product.getContext().getString(R.string.unit,products.get(position).getUnits()));
//        holder.text_quantity.setText(holder.edit_text_product.getContext().getString(R.string.amount,products.get(position).getQuantity()));
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
//        CardView card_view;
        ToggleButton productToggle;
        TextView edit_text_product,text_quantity,text_unit, txt_price;
        LinearLayout product_layout;
//        CircleImageView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.edit_text_product=(TextView)itemView.findViewById(R.id.edit_text_product);
            this.text_quantity=itemView.findViewById(R.id.text_quantity);
            this.text_unit=itemView.findViewById(R.id.text_unit);
            this.txt_price=itemView.findViewById(R.id.text_price);
        }

    }
}



