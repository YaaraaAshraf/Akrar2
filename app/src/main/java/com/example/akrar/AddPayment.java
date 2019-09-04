package com.example.akrar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class AddPayment extends AppCompatActivity {
    ToggleButton nationalIDToggle, addressToggle, amountToggle, currencyToggle, descriptionToggle;
    TextView nationalIDText, addressText, amountText, currencyText, descriptionText;

    long selectedInvoiceID;
    boolean isSentInvoice;


    ImageView img_arrow;
    //    ImageView fab;
//    Switch aSwitch;
    public RecyclerView recyclerView;
    ViewInvoicePaymentAdapter adapter;
    InvoicesService invoicesService;
    AlertDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
        selectedInvoiceID = getIntent().getIntExtra("Selected_invoice_id", 0);
        isSentInvoice = getIntent().getBooleanExtra("Selected_invoice_type_sent", false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);// if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();

        recyclerView = (RecyclerView) findViewById(R.id.products_recycler_view);
        adapter = new ViewInvoicePaymentAdapter(new ArrayList<paymentobject>());
////        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPayment.this.finish();
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
        Call call = invoicesService.getpaymentinvoice("Bearer " + token, id);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<InvoicepaymentData> data = (ResObj<InvoicepaymentData>) response.body();
                    if (data.getStatus().equals("success")) {
                        fillInvoiceData(data.getData(), isSentInvoice);

                    } else {
                        Toast.makeText(AddPayment.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddPayment.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(AddPayment.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void fillInvoiceData(InvoicepaymentData invoiceDetailsData, boolean isSentInvoice) {
            InvoicepaymentData invoice = (InvoicepaymentData) invoiceDetailsData.getPayment();
        List<paymentobject> products = invoice.getPayment();
//        if (isSentInvoice)
//            nationalIDText.setText(invoice.getSender().getNationalId());
//        else
//            nationalIDText.setText(invoice.getReceiver().getNationalId());
//        addressText.setText(invoice.getShipmentInvoice().getAddress());
//        amountText.setText(invoice.getShipmentInvoice().getTotal());
//        currencyText.setText(invoice.getShipmentInvoice().getCurrency().getName());
//        descriptionText.setText(invoice.getShipmentInvoice().getDescription());
        if (products != null)
            adapter.setData((ArrayList<paymentobject>) products);
//        nationalIDToggle = findViewById(R.id.national_id_toggle);
//        nationalIDText = findViewById(R.id.national_id_finan);
//        nationalIDLayout = findViewById(R.id.national_id_layout);
//        nationalIDToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                nationalIDText.setVisibility(isChecked? View.VISIBLE:View.GONE);
    }
}

