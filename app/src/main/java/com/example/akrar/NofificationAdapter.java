package com.example.akrar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NofificationAdapter extends RecyclerView.Adapter<NofificationAdapter.ViewHolder> {
    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public NofificationAdapter(MyListData[] listdata) {
        this.listdata = listdata;
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
        final MyListData myListData = listdata[position];
        holder.txt_notif.setText(listdata[position].getNotiname());
        holder.txt_time.setText(listdata[position].getTime());
    }
    @Override
    public int getItemCount() {
        return listdata.length;
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


