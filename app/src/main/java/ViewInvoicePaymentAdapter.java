//public class ViewInvoicePaymentAdapter extends RecyclerView.Adapter<ViewInvoicePaymentAdapter.ViewHolder> {
//    private ArrayList<paymentobject> products;
//
//    public ViewInvoicePaymentAdapter(ArrayList<paymentobject> products) {
//        this.products = products;
//    }
//    public void setData(ArrayList<paymentobject> invoices){
//        this.products = invoices;
//        notifyDataSetChanged();
//    }
//    @NonNull
//    @Override
//    public ViewInvoicePaymentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem= layoutInflater.inflate(R.layout.view_payment_list_item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(listItem);
//        return viewHolder;
//    }
//    @Override
//    public void onBindViewHolder(@NonNull ViewInvoicePaymentAdapter.ViewHolder holder, int position) {
////        final Product myListData = products.get(position);
//        holder.txt_name.setText(holder.txt_name.getContext().getString(R.string.paymentName,products.get(position).getProduct().getPaid()));
//        holder.txt_price.setText(holder.txt_name.getContext().getString(R.string.paymentpaid,products.get(position).getPayment()));
//        holder.txt_unit.setText(holder.txt_name.getContext().getString(R.string.paymentrest,products.get(position).getRest()));
//        holder.productToggle.setTextOn(holder.txt_name.getContext().getString(R.string.payment_number,position+1));
//        holder.productToggle.setTextOff(holder.txt_name.getContext().getString(R.string.payment_number,position+1));
//        holder.productToggle.setText(holder.txt_name.getContext().getString(R.string.payment_number,position+1));
//    }
//    @Override
//    public int getItemCount() {
//        return products.size();
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder {
////        CardView card_view;
//        ToggleButton productToggle;
//        TextView txt_name,txt_amount,txt_unit, txt_price;
//        LinearLayout product_layout;
//        ToggleButton nationalIDToggle;
////        CircleImageView status;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.productToggle=itemView.findViewById(R.id.product_toggle);
//            this.product_layout=itemView.findViewById(R.id.product_sub_layout);
//            this.productToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    product_layout.setVisibility(isChecked?View.VISIBLE:View.GONE);
//                }
//            });
//            this.txt_name=(TextView)itemView.findViewById(R.id.product_name_text_view);
//            this.txt_amount=(TextView)itemView.findViewById(R.id.amount_text_view);
//            this.txt_unit=itemView.findViewById(R.id.amount);
//            this.nationalIDToggle=itemView.findViewById(R.id.product_toggle);
//        }
//    }
//}


