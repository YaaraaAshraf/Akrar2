package com.example.akrar;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoiceDetailsData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinancialInvoiceDetailsActivity extends AppCompatActivity {
//    LinearLayout nationalIDLayout,addressLayout,amountLayout,currencyLayout, descriptionLayout;

    ToggleButton nationalIDToggle,addressToggle,amountToggle,currencyToggle,descriptionToggle;
    TextView nationalIDText, addressText,amountText,currencyText,descriptionText;

    long selectedInvoiceID;
    boolean isSentInvoice;


    ImageView image_add_bond, img_arrow;
    //    ImageView fab;
//    Switch aSwitch;
    public RecyclerView recyclerView;
    ViewInvoiceProductsAdapter adapter;
    InvoicesService invoicesService;
    AlertDialog loadingDialog;
//    boolean isRecievedInvoicesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_financial_details_activity);

        selectedInvoiceID = getIntent().getIntExtra("Selected_invoice_id",0);
        isSentInvoice = getIntent().getBooleanExtra("Selected_invoice_type_sent",false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);// if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();

        nationalIDToggle = findViewById(R.id.national_id_toggle);
        nationalIDText = findViewById(R.id.national_id_finan);
//        nationalIDLayout = findViewById(R.id.national_id_layout);
        nationalIDToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                nationalIDText.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });
//        addressLayout = findViewById(R.id.address_layout);
//        amountLayout = findViewById(R.id.total_amount_layout);
//        currencyLayout = findViewById(R.id.currency_layout);
//        descriptionLayout = findViewById(R.id.description_layout);


        addressToggle = findViewById(R.id.address_toggle);
        addressText = findViewById(R.id.address);
        addressToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                addressText.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });


        amountToggle = findViewById(R.id.total_amount_toggle);
        amountText = findViewById(R.id.amount);
        amountToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                amountText.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });
        currencyToggle = findViewById(R.id.currency_toggle);
        currencyText = findViewById(R.id.currency);
        currencyToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currencyText.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });

        descriptionToggle = findViewById(R.id.description_toggle);
        descriptionText = findViewById(R.id.description);
        descriptionToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                descriptionText.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.products_recycler_view);
        adapter = new ViewInvoiceProductsAdapter(new ArrayList<Product>());
////        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FinancialInvoiceDetailsActivity.this.finish();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        getInvoiceDetails(selectedInvoiceID, isSentInvoice);
    }
    public void getInvoiceDetails(long id, boolean isSentInvoice) {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.getInvoiceFinancialDetails("Bearer " + token, id);
        call.enqueue(new Callback(){
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<InvoiceDetailsData> data = (ResObj<InvoiceDetailsData>) response.body();
                    if (data.getStatus().equals("success")) {
                        fillInvoiceData(data.getData(), isSentInvoice);

                    } else {
                        Toast.makeText(FinancialInvoiceDetailsActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(FinancialInvoiceDetailsActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(FinancialInvoiceDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void fillInvoiceData(InvoiceDetailsData invoiceDetailsData, boolean isSentInvoice){
        Invoice invoice = invoiceDetailsData.getFinancialInvoice();
        List<Product> products = invoiceDetailsData.getFinancialProducts();
        if(isSentInvoice)
            nationalIDText.setText(invoice.getSender().getNationalId());
        else
            nationalIDText.setText(invoice.getReceiver().getNationalId());
        addressText.setText(invoice.getShipmentInvoice().getAddress());
        amountText.setText(invoice.getShipmentInvoice().getTotal());
        currencyText.setText(invoice.getShipmentInvoice().getCurrency().getName());
        descriptionText.setText(invoice.getShipmentInvoice().getDescription());
        if(products != null)
            adapter.setData((ArrayList<Product>) products);
    }
}
