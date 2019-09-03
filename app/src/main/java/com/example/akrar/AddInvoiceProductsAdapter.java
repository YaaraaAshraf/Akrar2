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
import android.widget.ToggleButton;

import com.example.akrar.products.model.Product;

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
//        notifyItemChanged(this.products.size()-1);
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

        holder.productNameEditTextListener.updatePosition(position);
        holder.productNameEditText.setText(products.get(position).getName());


        holder.unitEditTextListener.updatePosition(position);
        holder.text_unit.setText(products.get(position).getUnits());


        holder.priceEditTextListener.updatePosition(position);
        holder.txt_price.setText(products.get(position).getPrice());


        holder.quantityEditTextListener.updatePosition(position);
        holder.text_quantity.setText(products.get(position).getQuantity());


        holder.existingProductCheckBox.setOnCheckedChangeListener(null);
        holder.existingProductCheckBox.setChecked(products.get(position).getStatus().equals("0"));
        holder.createOnCheckListener();

        holder.productsSpinner.setOnItemSelectedListener(null);
        holder.productsSpinner.setSelection(holder.productsSpinnerAdapter.getIndexForProductID(products.get(position).getProduct_id()));
        holder.createOnItemSelectedListener();

        holder.productNameEditText.setVisibility(products.get(position).getStatus().equals("0") ? View.GONE : View.VISIBLE);
        if(position == products.size()-1)
            holder.existingProductCheckBox.requestFocus();
        holder.productsSpinner.setVisibility(products.get(position).getStatus().equals("0") ? View.VISIBLE : View.GONE);

//        holder.productNameEditText.requestFocus();

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

        public EditTextListener productNameEditTextListener;
        public EditTextListener quantityEditTextListener;
        public EditTextListener priceEditTextListener;
        public EditTextListener unitEditTextListener;

        //        CircleImageView status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            this.text_quantity = itemView.findViewById(R.id.text_quantity);
            this.quantityEditTextListener = new EditTextListener(EditTextListener.QUANTITY);
            this.text_quantity.addTextChangedListener(quantityEditTextListener);

            this.text_unit = itemView.findViewById(R.id.text_unit);
            this.unitEditTextListener = new EditTextListener(EditTextListener.UNIT);
            this.text_unit.addTextChangedListener(unitEditTextListener);

            this.txt_price = itemView.findViewById(R.id.text_price);
            this.priceEditTextListener = new EditTextListener(EditTextListener.PRICE);
            this.txt_price.addTextChangedListener(priceEditTextListener);

            this.productNameEditText = itemView.findViewById(R.id.edit_text_product);
            this.productNameEditTextListener = new EditTextListener(EditTextListener.NAME);
            this.productNameEditText.addTextChangedListener(productNameEditTextListener);


            this.existingProductCheckBox = itemView.findViewById(R.id.existing_product_checkbox);
            this.productsSpinner = itemView.findViewById(R.id.spinner_product);
            productsSpinnerAdapter = new ProductsSpinnerAdapter(itemView.getContext(),
                    R.layout.spinner_item, "Product");
            productsSpinnerAdapter.setData(alreadyExistingProducts);
            productsSpinner.setAdapter(productsSpinnerAdapter);





        }

        private void createOnItemSelectedListener(){
            this.productsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    products.get(ViewHolder.this.getAdapterPosition()).setProduct_id(productsSpinnerAdapter.getData().get(position).getProduct_id());
//                    products.get(ViewHolder.this.getAdapterPosition()).setStatus("0");
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) { }
            });
        }

        private void createOnCheckListener()
        {
            this.existingProductCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    getProducts().get(ViewHolder.this.getAdapterPosition()).setStatus(isChecked?"0":"1");
//                    if(isChecked)
//                        getProducts().get(ViewHolder.this.getAdapterPosition()).setName("");
//                    else
//                        getProducts().get(ViewHolder.this.getAdapterPosition()).setProduct_id("");
                    notifyDataSetChanged();

                }
            });
        }

    }

//    private class OnCheckBoxCheckedChange implements new CompoundButton.OnCheckedChangeListener()

    private class EditTextListener implements TextWatcher {
        private int position;
        private int updatedField;
        final static int NAME=1;
        final static int QUANTITY=2;
        final static int PRICE=3;
        final static int PRODUCT_ID=4;
        final static int UNIT=5;

        public EditTextListener(int updatedField) {
            this.updatedField = updatedField;
        }

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            switch (this.updatedField){
                case NAME:
                    products.get(position).setName(charSequence.toString());
                    break;

//                case PRODUCT_ID:
//                    products.get(position).setProduct_id(productsSpinnerAdapter.getData().get(position).getProduct_id());
//                    break;

                case UNIT:
                    products.get(position).setUnits(charSequence.toString());
                    break;

                case QUANTITY:
                    products.get(position).setQuantity(charSequence.toString());
                    break;

                case PRICE:
                    products.get(position).setPrice(charSequence.toString());
                    break;
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {
//            products.get(position).setName(editable.toString());
            // no op
        }
    }
}



