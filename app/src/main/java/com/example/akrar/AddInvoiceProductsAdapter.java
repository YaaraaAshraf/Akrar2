package com.example.akrar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.akrar.products.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddInvoiceProductsAdapter extends RecyclerView.Adapter<AddInvoiceProductsAdapter.ViewHolder> {
    private ArrayList<Product> products;
    private ArrayList<Product> alreadyExistingProducts;

    public AddInvoiceProductsAdapter(ArrayList<Product> products) {
        this.products = products;
        this.alreadyExistingProducts = new ArrayList<>();

    }

    public void setData(ArrayList<Product> invoices) {
        this.products = invoices;
        notifyDataSetChanged();
    }

    public void setAlreadyExistingProducts(ArrayList<Product> alreadyExistingProducts){
        this.alreadyExistingProducts = alreadyExistingProducts;
        notifyDataSetChanged();
    }

    public void addProduct(Product product) {
        this.products.add(product);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddInvoiceProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.add_invoice_product_layout, parent, false);
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        CardView card_view;
        ToggleButton productToggle;
        EditText text_quantity, text_unit, txt_price;
        LinearLayout product_layout;
        CheckBox existingProductCheckBox;
        EditText productNameEditText;
        Spinner productsSpinner;
        ProductsSpinnerAdapter productsSpinnerAdapter;

        //        CircleImageView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            this.edit_text_product = itemView.findViewById(R.id.edit_text_product);
//            this.edit_text_product.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    products.get(ViewHolder.this.getAdapterPosition()).setName(s.toString());
//                }
//            });
            this.text_quantity = itemView.findViewById(R.id.text_quantity);
//            this.text_quantity.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    products.get(ViewHolder.this.getAdapterPosition()).setQuantity(s.toString());
//                }
//            });
            this.text_unit = itemView.findViewById(R.id.text_unit);
//            this.text_unit.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    products.get(ViewHolder.this.getAdapterPosition()).setUnits(s.toString());
//                }
//            });;
            this.txt_price = itemView.findViewById(R.id.text_price);
//            this.txt_price.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    products.get(ViewHolder.this.getAdapterPosition()).setPrice(s.toString());
//                }
//            });
            this.productNameEditText = itemView.findViewById(R.id.edit_text_product);
//            this.productNameEditText.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    products.get(ViewHolder.this.getAdapterPosition()).setName(s.toString());
//                    products.get(ViewHolder.this.getAdapterPosition()).setStatus("1");
//                }
//            });
            this.existingProductCheckBox = itemView.findViewById(R.id.existing_product_checkbox);
            this.productsSpinner = itemView.findViewById(R.id.spinner_product);
            productsSpinnerAdapter = new ProductsSpinnerAdapter(itemView.getContext(),
                    R.layout.spinner_item, "Product");
            productsSpinnerAdapter.setData(alreadyExistingProducts);
            productsSpinner.setAdapter(productsSpinnerAdapter);

//            this.productsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    products.get(ViewHolder.this.getAdapterPosition()).setProduct_id(productsSpinnerAdapter.getData().get(position).getProduct_id());
//                    products.get(ViewHolder.this.getAdapterPosition()).setStatus("0");
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) { }
//            });



//            this.existingProductCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//                    productNameEditText.setVisibility(isChecked ? View.GONE : View.VISIBLE);
//                    productsSpinner.setVisibility(isChecked ? View.VISIBLE : View.GONE);
//                }
//            });

//            this.existingProductCheckBox
        }

    }
}



