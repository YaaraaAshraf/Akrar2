package com.example.akrar;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.CurrenciesData;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.Currency;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.Product;
import com.example.akrar.products.model.ProductData;
import com.example.akrar.products.model.ProductsService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AddDocumentShipmentInvoiceActivity extends AppCompatActivity {
    ImageView img_back, img_calender;
    EditText txt_date, edtext_sendto_bonds, edt_address_bonds,
            edt_name_of_product_bonds, text_quantity_bonds,
            text_value_bonds, text_date_bonds, text_description_bonds, productNameEditText;
    Button btn_send,addProductButton;
    Spinner productsSpinner;
    Spinner currencySpinner;
    CheckBox existingProductCheckBox;
    InvoicesService invoicesService;
    ProductsService productsService;
    AlertDialog loadingDialog;
    CurrencySpinnerAdapter currencySpinnerAdapter;
    ProductsSpinnerAdapter productsSpinnerAdapter;

    RecyclerView recyclerView;
    AddInvoiceProductsAdapter adapter;

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
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        edtext_sendto_bonds = findViewById(R.id.edtext_sendto_bonds);
        edt_address_bonds = findViewById(R.id.edt_address_bonds);
        edt_name_of_product_bonds = findViewById(R.id.edt_name_of_product_bonds);
//        productsSpinner = findViewById(R.id.spinner_product);
//        currencySpinner = findViewById(R.id.spinner1_currency);
//        productNameEditText = findViewById(R.id.edit_text_product);

        existingProductCheckBox = findViewById(R.id.existing_product_checkbox);
        existingProductCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                productNameEditText.setVisibility(isChecked ? View.GONE : View.VISIBLE);
//                productsSpinner.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
        text_description_bonds = (EditText) findViewById(R.id.text_description_bonds);
        addProductButton = (Button) findViewById(R.id.button_payments);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addProduct(new Product("Testing product","unit","4233","33"));
//                st_date=txt_date.getText().toString();
//                 st_sendto=edtext_sendto_bonds.getText().toString();
//                 st_address=edt_address_bonds.getText().toString();
//                 st_productname=edt_name_of_product_bonds.getText().toString();
//                 st_quantitiy=text_quantity_bonds.getText().toString();
//                 st_value=text_value_bonds.getText().toString();
//                 st_desc=text_description_bonds.getText().toString();
//                FragmentTransaction transection=getFragmentManager().beginTransaction();
//                Document_shipment mfragment=new Document_shipment();
//                //using Bundle to send data
//                Bundle bundle=new Bundle();
//                bundle.putString("date",st_date);
//                bundle.putString("name",st_sendto);
//                bundle.putString("address",st_address);
//                bundle.putString("productname",st_productname);
//                bundle.putString("quantity",st_quantitiy);
//                bundle.putString("value",st_value);
//                bundle.putString("des",st_desc);
//                mfragment.setArguments(bundle); //data being send to SecondFragment
//                transection.replace(R.id.frame_container, mfragment);
//                transection.commit();
//              send(new salary_documents());
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
        Call call = invoicesService.addShipmentInvoice("Bearer " + token,edtext_sendto_bonds.getText().toString(),"1","Company address 1","des","321");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
//                    ResObj<CurrenciesData> data = (ResObj<CurrenciesData>) response.body();
//                    if (data.getStatus().equals("success")) {
//
////                        currencySpinnerAdapter = new CurrencySpinnerAdapter(AddDocumentShipmentInvoiceActivity.this,
////                                R.layout.spinner_item, "Dollar");
////                        currencySpinnerAdapter.setData((data.getData().getCurrencies()));
////                        currencySpinner.setAdapter(currencySpinnerAdapter);
//                    } else {
//                        Toast.makeText(AddDocumentShipmentInvoiceActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
//                    }
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

//                        currencySpinnerAdapter = new CurrencySpinnerAdapter(AddDocumentShipmentInvoiceActivity.this,
//                                R.layout.spinner_item, "Dollar");
//                        currencySpinnerAdapter.setData((data.getData().getCurrencies()));
//                        currencySpinner.setAdapter(currencySpinnerAdapter);
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
//                        productsSpinnerAdapter = new ProductsSpinnerAdapter(AddDocumentShipmentInvoiceActivity.this,
//                                R.layout.spinner_item, "Product");
//                        productsSpinnerAdapter.setData((data.getData().getProducts()));
//                        productsSpinner.setAdapter(productsSpinnerAdapter);
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
