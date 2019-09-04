package com.example.akrar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akrar.products.model.Product;

import java.util.ArrayList;
import java.util.List;

public class NofificationAdapter extends RecyclerView.Adapter<NofificationAdapter.ViewHolder> {
//    private MyListData[] listdata;
    private List<NotificationObject> listdataa;
    // RecyclerView recyclerView;
    public NofificationAdapter(List<NotificationObject> listdata) {
        this.listdataa = listdata;
    }

    @NonNull
    @Override
    public NofificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull NofificationAdapter.ViewHolder holder, int position) {
        final NotificationObject notificationObject=listdataa.get(position);
        holder.txt_notif.setText(notificationObject.getMsg());
        holder.txt_time.setText(notificationObject.getCreated_at());
//        holder.txt_notif.setText(listdata[position].getNotiname());
//        holder.txt_time.setText(listdata[position].getTime());
    }
    @Override
    public int getItemCount() {
        return listdataa.size();
    }
    public void setListdata(ArrayList<NotificationObject> productArrayList) {
        this.listdataa = productArrayList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_notif,txt_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_notif=(TextView)itemView.findViewById(R.id.txt_notif);
            this.txt_time=(TextView)itemView.findViewById(R.id.text_time);
        }
    }
}


