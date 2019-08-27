package com.example.akrar.products;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.akrar.MainActivity;
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

public class ProductsListActivity extends AppCompatActivity {
    ImageView img_add, img_arrow;
    ProductsService productsService;
    RecyclerView productsRecyclerView;
    ProductsAdapter adapter;
    AlertDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productsService = ApiUtils.getProductsService();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();

        productsRecyclerView = (RecyclerView) findViewById(R.id.products_recycler);
        adapter = new ProductsAdapter(new ArrayList<Product>());
        productsRecyclerView.setHasFixedSize(true);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        productsRecyclerView.setAdapter(adapter);

        img_arrow = (ImageView) findViewById(R.id.image_my_productarrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
//                back(new Mainpage_details());
            }
        });

        img_add = (ImageView) findViewById(R.id.image_add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddProductActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        getProducts();
    }

    private void getProducts() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = productsService.getProducts("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<ProductData> resObj = (ResObj<ProductData>) response.body();
                    if (resObj.getStatus().equals("success")) {
                        adapter.setListdata((ArrayList<Product>) resObj.getData().getProducts());
                        //use this user to fill the fields you have
//                        User user = resObj.getData().getUser();
//                        edtext_name.setText(user.getFirstName());
//                        edtext_mail.setText(user.getEmail());
//                        edtext_phone.setText(user.getMobile());
//                        text_national_id.setText(user.getNationalID());

                    } else {
                        Toast.makeText(ProductsListActivity.this.getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
                    Toast.makeText(ProductsListActivity.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(ProductsListActivity.this.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



//    private boolean back(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
//    private boolean loadAddProducts(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
}

