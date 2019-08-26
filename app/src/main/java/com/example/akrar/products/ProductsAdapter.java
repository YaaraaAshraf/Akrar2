package com.example.akrar.products;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.akrar.R;
import com.example.akrar.products.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> listdata;

    // RecyclerView recyclerView;
    public ProductsAdapter(List<Product> listdata) {
        this.listdata = listdata;
    }
    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.product_list_item, parent, false);
        ProductsAdapter.ViewHolder viewHolder = new ProductsAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        final Product myListData = listdata.get(position);
        holder.txt_proddes.setText(myListData.getName());
//        holder.txt_price.setText(myListData.getPrice());
//        holder.txt_units.setText(myListData.getUnits());
//        holder.img_delete.setImageResource(myListData.getImg_delete());
//        holder.img_edit.setImageResource(myListData.getImg_edit());

    }
    public int getItemCount() {
        return listdata.size();
    }
    public void setListdata(ArrayList<Product> productArrayList){
        this.listdata = productArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_proddes, txt_units, txt_price;
        ImageView img_delete, img_edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_proddes = (TextView) itemView.findViewById(R.id.text_prod_desc);
            txt_units = (TextView) itemView.findViewById(R.id.txt_unit);
            txt_price = (TextView) itemView.findViewById(R.id.txt_price);
            img_delete = (ImageView) itemView.findViewById(R.id.img_delete);
            img_edit = (ImageView) itemView.findViewById(R.id.img_edit);
        }
    }
}