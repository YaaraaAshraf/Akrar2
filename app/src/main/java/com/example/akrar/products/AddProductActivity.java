package com.example.akrar.products;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.akrar.R;
import com.example.akrar.UserSharedPreferencesManager;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.Product;
import com.example.akrar.products.model.ProductData;
import com.example.akrar.products.model.ProductsService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {
    ImageView image_product_arrow;
    Button btn_save;
    EditText productNameEditText;
    ProductsService productsService;
    AlertDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        productsService = ApiUtils.getProductsService();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();

        productNameEditText = findViewById(R.id.edtext_name_product);

        btn_save = (Button) findViewById(R.id.btn_prod);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });
        image_product_arrow = (ImageView) findViewById(R.id.image_product_arrow);
        image_product_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddProductActivity.this.finish();
//                 Intent intent = new Intent(getApplicationContext(), ProductsListActivity.class);
//                 startActivity(intent);
            }
        });
    }

    private void addProduct() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = productsService.addProduct("Bearer " + token, productNameEditText.getText().toString());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj resObj = (ResObj) response.body();
                    if (resObj.getStatus().equals("success")) {
                        Toast.makeText(AddProductActivity.this.getApplicationContext(), "Product Added successfully!", Toast.LENGTH_SHORT).show();
                        AddProductActivity.this.finish();
                    }
                    else{
                        Toast.makeText(AddProductActivity.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(AddProductActivity.this.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

