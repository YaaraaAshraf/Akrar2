package com.example.akrar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoiceUser;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.ProductData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinancialAdapter extends RecyclerView.Adapter<FinancialAdapter.ViewHolder> {

    private ArrayList<Invoice> invoices;

    public FinancialAdapter(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void setData(ArrayList<Invoice> invoices){
        this.invoices = invoices;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FinancialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_financial_listitem, parent, false);
        FinancialAdapter.ViewHolder viewHolder = new FinancialAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FinancialAdapter.ViewHolder holder, int position) {
        final Invoice myListData = invoices.get(position);
        if (invoices.get(position).getReceiver() != null) {
            holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.invoice_from, invoices.get(position).getReceiver().getFirstName()));
            holder.txt_user_id.setText(invoices.get(position).getReceiver().getNationalId());
        } else if (invoices.get(position).getSender() != null) {
            holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.invoice_to, invoices.get(position).getSender().getFirstName()));
            holder.txt_user_id.setText(invoices.get(position).getSender().getNationalId());
        }
        holder.txt_date.setText(invoices.get(position).getDate());
        holder.txt_date.setVisibility(invoices.get(position).getDate() == null ? View.GONE : View.VISIBLE);
        Drawable color;
        if (invoices.get(position).getStatus() == 0) {
            color = new ColorDrawable(holder.txt_type.getContext().getResources().getColor(R.color.green));
        } else {
            color = new ColorDrawable(holder.txt_type.getContext().getResources().getColor(R.color.fabcolorxx));
        }
        holder.txt_type.setTextColor(((ColorDrawable) color).getColor());
    }
    @Override
    public int getItemCount() {
        return invoices.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_view;
        TextView txt_name, txt_date, txt_user_id, txt_type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_user_id=(TextView)itemView.findViewById(R.id.txt_name_fin);
            this.card_view= itemView.findViewById(R.id.card_view);
            this.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),FinancialInvoiceDetailsActivity.class);
                    intent.putExtra("Selected_invoice_id",invoices.get(FinancialAdapter.ViewHolder.this.getAdapterPosition()).getId());
                    intent.putExtra("Selected_invoice_type_sent",invoices.get(FinancialAdapter.ViewHolder.this.getAdapterPosition()).getSender() !=null);
                    v.getContext().startActivity(intent);
                    ViewHolder.this.getAdapterPosition();
                }
            });
            this.txt_date=itemView.findViewById(R.id.txt_date_fin);
            this.txt_user_id= itemView.findViewById(R.id.txt_user_id);
            this.txt_name = itemView.findViewById(R.id.txt_name_fin);
            this.txt_type= itemView.findViewById(R.id.txt_type);
//            this.status=itemView.findViewById(R.id.status);
        }

    }
}
//    private ArrayList<Invoice> invoices;
//    private Context getActivity;
//    public FinancialAdapter(ArrayList<Invoice> invoices) {
//        this.invoices = invoices;
//    }
//    public void setData(ArrayList<Invoice> invoices) {
//        this.invoices = invoices;
//        notifyDataSetChanged();
//    }
//    @NonNull
//    @Override
//    public FinancialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem = layoutInflater.inflate(R.layout.activity_financial_listitem, parent, false);
//        ViewHolder viewHolder = new ViewHolder(listItem);
//        return viewHolder;
//    }
//    @Override
//    public void onBindViewHolder(@NonNull FinancialAdapter.ViewHolder holder, int position) {
//        final Invoice myListData = invoices.get(position);
//        if (invoices.get(position).getReceiver() != null) {
//            holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.invoice_from, invoices.get(position).getReceiver().getFirstName()));
//            holder.txt_user_id.setText(invoices.get(position).getReceiver().getNationalId());
//        } else if (invoices.get(position).getSender() != null) {
//            holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.invoice_to, invoices.get(position).getSender().getFirstName()));
//            holder.txt_user_id.setText(invoices.get(position).getSender().getNationalId());
//        }
//        holder.txt_date.setText(invoices.get(position).getDate());
//        holder.txt_date.setVisibility(invoices.get(position).getDate() == null ? View.GONE : View.VISIBLE);
//        Drawable color;
//        if (invoices.get(position).getStatus() == 0) {
//            color = new ColorDrawable(holder.txt_type.getContext().getResources().getColor(R.color.green));
//        } else {
//            color = new ColorDrawable(holder.txt_type.getContext().getResources().getColor(R.color.fabcolorxx));
//        }
//        holder.txt_type.setTextColor(((ColorDrawable) color).getColor());
//    }
////        holder.txt_name.setText(invoices.get(position).getReceiver().getFirstName());
////        holder.txt_date.setText(invoices.get(position).getDate());
////        holder.txt_user_id.setText(invoices.get(position).getReceiver().getNationalId());
//
//    //        if (invoices.get(position).getReceiver().getStatus()==0){
////            holder.txt_type.setText("كاش");
////        }else {
////            holder.txt_type.setText("اجل");
////            holder.txt_type.setTextColor(Color.RED);
////        }
//    @Override
//    public int getItemCount() {
//        return invoices.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView txt_name, txt_date, txt_user_id, txt_type;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.txt_name = (TextView) itemView.findViewById(R.id.txt_name_fin);
//            this.txt_date = (TextView) itemView.findViewById(R.id.txt_date_fin);
//            this.txt_user_id = (TextView) itemView.findViewById(R.id.txt_user_id);
//            this.txt_type = (TextView) itemView.findViewById(R.id.text_type);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(),
//                            Financial_Invoice.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
//        }
//    }
//    }
