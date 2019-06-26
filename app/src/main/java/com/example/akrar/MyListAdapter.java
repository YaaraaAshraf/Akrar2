package com.example.akrar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }


    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
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
//jjk


