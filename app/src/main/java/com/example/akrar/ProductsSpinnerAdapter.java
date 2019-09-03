package com.example.akrar;

import android.content.Context;

import com.example.akrar.model.Currency;
import com.example.akrar.products.model.Product;

import java.util.List;

public class ProductsSpinnerAdapter extends SpinnerAdapter<Product> {

    public ProductsSpinnerAdapter(Context context, int resource, List data, String defaultValueTitle) {
        super(context, resource, data, defaultValueTitle);
    }
    public ProductsSpinnerAdapter(Context context, int resource, String defaultValueTitle) {
        super(context, resource, defaultValueTitle);
    }
    @Override
    protected String getTitle(int position) {
        return mData.get(position).getName();
    }
    @Override
    public List<Product> getData() {
        return super.getData();
    }

    public int getIndexForProductID(String productID){
        for (int i=0; i<mData.size();i++) {
            Product product = mData.get(i);
            if(product.getProduct_id().equals(productID))
                return i;
        }
        return -1;
    }
}
