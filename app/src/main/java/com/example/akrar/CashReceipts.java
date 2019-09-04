package com.example.akrar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.products.model.Product;
import com.example.akrar.products.model.ProductsService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CashReceipts extends AppCompatActivity {
    ImageView image_arrow;
    EditText editText_value;
    TextView editText_date;
    Button btn_add_payment, btn_send;
    LinearLayout container;
    RecyclerView recyclerView;
    CashListAdapter adapter;
    InvoicesService invoicesService;
    ProductsService productsService;
    AlertDialog loadingDialog;
    ArrayList<String> listdata_cash;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH) + 1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    int N = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_receipts);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();
        productsService = ApiUtils.getProductsService();

        editText_value = (EditText) findViewById(R.id.edittext_value);
        btn_add_payment = (Button) findViewById(R.id.btn_payments);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Invoice selectedShipmentInvoice = (Invoice) getIntent().getSerializableExtra("selectedShipmentInvoice");
                String description = getIntent().getStringExtra("description");
                addFinancialinvoice(selectedShipmentInvoice,description);

//                selectedShipmentInvoice
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.cash_recycler);
        adapter = new CashListAdapter(new ArrayList<Rowitem_cash>());
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        container = (LinearLayout) findViewById(R.id.container);

        editText_date = findViewById(R.id.edittext_date);

        btn_add_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addPayment(new Rowitem_cash());
                if (adapter.getItemCount() > 11)
                    btn_add_payment.setVisibility(View.INVISIBLE);
                else
                    btn_add_payment.setVisibility(View.VISIBLE);
            }
        });
        image_arrow = (ImageView) findViewById(R.id.image_arrow);
        image_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CashReceipts.this, Add_Financial_Invoice.class);
                startActivity(intent);
            }
        });
    }

    private void addFinancialinvoice(Invoice selectedShipmentInvoice, String description) {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.add_financial_invoice("Bearer " + token,""+selectedShipmentInvoice.getId(),"1",description, getPaymentsAsMap());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
//                    ResObj<InvoicesData> data = (ResObj<InvoicesData>) response.body();
//                    if (data.getStatus().equals("success")) {
                    Toast.makeText(CashReceipts.this.getApplicationContext(), " Added successfully!", Toast.LENGTH_SHORT).show();
                    CashReceipts.this.finish();
//                    }
//                    else{
//                        Toast.makeText(Add_Financial_Invoice.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                    }
                }
                else{
                    Toast.makeText(CashReceipts.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(CashReceipts.this.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Map<String, String> getPaymentsAsMap() {
        HashMap<String, String> productsMap = new HashMap<>();
        ArrayList<Rowitem_cash> products = adapter.getPaymentList();
        Rowitem_cash product = null;
        for (int i = 0; i < products.size(); i++) {
            product = products.get(i);

            if (product.getPayment() != null) {
                String statusKey = "payments[" + i + "][payment]";
                productsMap.put(statusKey, product.getPayment());
            }
            if (product.getDate() != null) {
                String statusKey = "payments[" + i + "][date]";
                productsMap.put(statusKey, product.getDate());
            }
        }

        return productsMap;
    }
}
