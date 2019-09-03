package com.example.akrar;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.CurrenciesData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.Currency;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.Product;
import com.example.akrar.products.model.ProductData;
import com.example.akrar.products.model.ProductsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDocumentShipmentInvoiceActivity extends AppCompatActivity {
    ImageView img_back, img_calender;
    EditText txt_date, edtext_sendto_bonds, edt_address_bonds,
            edt_name_of_product_bonds, text_quantity_bonds,
            text_value_bonds, text_date_bonds, text_description_bonds, productNameEditText;
    Button btn_send, addProductButton;
    Spinner currencySpinner;
    InvoicesService invoicesService;
    ProductsService productsService;
    AlertDialog loadingDialog;
    CurrencySpinnerAdapter currencySpinnerAdapter;

    RecyclerView recyclerView;
    AddInvoiceProductsAdapter adapter;

    private ArrayList<Product> alreadyExistingProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_shipment_invoice);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();
        productsService = ApiUtils.getProductsService();

        recyclerView = (RecyclerView) findViewById(R.id.products_recycler_view);
        adapter = new AddInvoiceProductsAdapter(new ArrayList<Product>());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        edtext_sendto_bonds = findViewById(R.id.edtext_sendto_bonds);
        edt_address_bonds = findViewById(R.id.edt_address_bonds);
        edt_name_of_product_bonds = findViewById(R.id.edt_name_of_product_bonds);
//        productsSpinner = findViewById(R.id.spinner_product);
        currencySpinner = findViewById(R.id.spinner1_currency);

        text_description_bonds = (EditText) findViewById(R.id.text_description_bonds);
        addProductButton = (Button) findViewById(R.id.button_payments);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addProduct(new Product());
            }
        });
        img_back = findViewById(R.id.image_arrow_bond);
        img_back.setOnClickListener(view -> AddDocumentShipmentInvoiceActivity.this.finish());
        listCurrencies();

        btn_send = (Button) findViewById(R.id.btn_deliver_bonds);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShipmentInvoice();
            }
        });
    }

    public void addShipmentInvoice() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
//        Call call = invoicesService.addShipmentInvoice("Bearer " + token,edtext_sendto_bonds.getText().toString(),"1","Company address 1","des","321",getProductsAsMap());
        Call call = invoicesService.addShipmentInvoice("Bearer " + token, edtext_sendto_bonds.getText().toString()
                , ""+((Currency)currencySpinner.getSelectedItem()).getId(), edt_address_bonds.getText().toString()
                , text_description_bonds.getText().toString(), edt_name_of_product_bonds.getText().toString(), getProductsAsMap());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<CurrenciesData> data = (ResObj<CurrenciesData>) response.body();
                    if (data.getStatus().equals("success")) {

                        Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Shipment invoice added successfully", Toast.LENGTH_SHORT).show();
                        AddDocumentShipmentInvoiceActivity.this.finish();
                    } else {
                        Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(AddDocumentShipmentInvoiceActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Map<String, String> getProductsAsMap() {
        HashMap<String, String> productsMap = new HashMap<>();
        ArrayList<Product> products = adapter.getProducts();
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            product = products.get(i);

            if (product.getStatus() != null) {
                String statusKey = "products[" + i + "][status]";
                productsMap.put(statusKey, product.getStatus());
            }

            if (product.getStatus().equals("0")&& product.getProduct_id() != null) {
                String productIDKey = "products[" + i + "][product_id]";
                productsMap.put(productIDKey, product.getProduct_id());
            } else {
                String nameKey = "products[" + i + "][name]";
                productsMap.put(nameKey, product.getName());
            }

            if (product.getQuantity() != null) {
                String quantityKey = "products[" + i + "][quantity]";
                productsMap.put(quantityKey, product.getQuantity());
            }

            if (product.getUnits() != null) {
                String unitKey = "products[" + i + "][unit]";
                productsMap.put(unitKey, product.getUnits());
            }

            if (product.getPrice() != null) {
                String priceKey = "products[" + i + "][price]";
                productsMap.put(priceKey, product.getPrice());
            }
        }

        return productsMap;
    }

    public void listCurrencies() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.listCurrencies("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    ResObj<CurrenciesData> data = (ResObj<CurrenciesData>) response.body();
                    if (data.getStatus().equals("success")) {

                        currencySpinnerAdapter = new CurrencySpinnerAdapter(AddDocumentShipmentInvoiceActivity.this,
                                R.layout.spinner_item, "Dollar");
                        currencySpinnerAdapter.setData((data.getData().getCurrencies()));
                        currencySpinner.setAdapter(currencySpinnerAdapter);
                    } else {
                        Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
                listProducts();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(AddDocumentShipmentInvoiceActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listProducts() {
//        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = productsService.getProducts("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<ProductData> data = (ResObj<ProductData>) response.body();
                    if (data.getStatus().equals("success")) {
                        adapter.addProduct(new Product());
                        alreadyExistingProducts = (ArrayList<Product>) data.getData().getProducts();
                        adapter.setAlreadyExistingProducts(alreadyExistingProducts);
                    } else {
                        Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(AddDocumentShipmentInvoiceActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
