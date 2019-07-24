package com.example.akrar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


  public class Products_Adapter extends RecyclerView.Adapter<Products_Adapter.ViewHolder> {
      private ListProduct[] listdata;

      // RecyclerView recyclerView;
      public Products_Adapter(ListProduct[] listdata) {
          this.listdata = listdata;
      }

      @NonNull
      @Override
      public Products_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
          View listItem= layoutInflater.inflate(R.layout.recycler_list_item, parent, false);
          Products_Adapter.ViewHolder viewHolder = new Products_Adapter.ViewHolder(listItem);
          return viewHolder;
      }

      @Override
      public void onBindViewHolder(@NonNull Products_Adapter.ViewHolder holder, int position) {
          final ListProduct myListData = listdata[position];
          holder.txt_proddes.setText(listdata[position].getProd_desc());
          holder.txt_price.setText(listdata[position].getPrice());
          holder.txt_units.setText(listdata[position].getUnits());
          holder.img_delete.setImageResource(listdata[position].getImg_delete());
          holder.img_edit.setImageResource(listdata[position].getImg_edit());


      }
      public int getItemCount() {
          return listdata.length;
      }

      public class ViewHolder extends RecyclerView.ViewHolder {
          TextView txt_proddes,txt_units,txt_price;
          ImageView img_delete,img_edit;
          public ViewHolder(@NonNull View itemView) {
              super(itemView);
              txt_proddes=(TextView)itemView.findViewById(R.id.text_prod_desc);
              txt_units=(TextView)itemView.findViewById(R.id.txt_unit);
              txt_price=(TextView)itemView.findViewById(R.id.txt_price);
              img_delete=(ImageView)itemView.findViewById(R.id.img_delete);
              img_edit=(ImageView)itemView.findViewById(R.id.img_edit);
          }
      }
  }

