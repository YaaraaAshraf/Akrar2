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
import android.widget.TextView;


import com.example.akrar.invoices.model.Invoice;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class InvoicesAdapter extends RecyclerView.Adapter<InvoicesAdapter.ViewHolder> {
    private ArrayList<Invoice> invoices;
    boolean isRecievedInvoices;

    public InvoicesAdapter(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void setData(ArrayList<Invoice> invoices, boolean isRecievedInvoices){
        this.invoices = invoices;
        this.isRecievedInvoices = isRecievedInvoices;
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
        if(!isRecievedInvoices && invoices.get(position).getReceiver() !=null) {
            holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.invoice_to,invoices.get(position).getReceiver().getFirstName()));
            holder.txt_phone.setText(invoices.get(position).getReceiver().getNationalId());
        }
        else if(invoices.get(position).getSender() !=null) {
            holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.invoice_from,invoices.get(position).getSender().getFirstName()));
            holder.txt_phone.setText(invoices.get(position).getSender().getNationalId());
        }
        holder.txt_date.setText(invoices.get(position).getDate());
        holder.txt_date.setVisibility(invoices.get(position).getDate() == null?View.GONE:View.VISIBLE);

        Drawable color;

        if(invoices.get(position).getStatus() == 0) {
            color = new ColorDrawable(holder.txt_name.getContext().getResources().getColor(R.color.fabcolorxx));
        }
        else{
            color = new ColorDrawable(holder.txt_name.getContext().getResources().getColor(R.color.green));
        }

        holder.status.setImageDrawable(color);

    }
    @Override
    public int getItemCount() {
        return invoices.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_view;
        TextView txt_name,txt_date,txt_phone;
        CircleImageView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_name=(TextView)itemView.findViewById(R.id.txt_name);
            this.card_view= itemView.findViewById(R.id.card_view);
            this.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DocumentInvoiceDetailsActivity.class);
                    intent.putExtra("Selected_invoice_id",invoices.get(ViewHolder.this.getAdapterPosition()).getId());
                    intent.putExtra("Selected_invoice_type_sent",invoices.get(ViewHolder.this.getAdapterPosition()).getSender() !=null);
                    v.getContext().startActivity(intent);
//                    ViewHolder.this.getAdapterPosition()
                }
            });
            this.txt_date=(TextView)itemView.findViewById(R.id.txt_date);
            this.txt_phone=(TextView)itemView.findViewById(R.id.txt_national_id);
            this.status=itemView.findViewById(R.id.status);
        }

    }
}



