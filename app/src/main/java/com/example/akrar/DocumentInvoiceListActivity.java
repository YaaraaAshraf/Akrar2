package com.example.akrar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class DocumentInvoiceListActivity extends AppCompatActivity {
    ImageView image_add_bond, img_arrow;
    ImageView fab;
    Switch aSwitch;
    public RecyclerView recyclerView;
    InvoicesAdapter adapter;
    InvoicesService invoicesService;
    AlertDialog loadingDialog;
    boolean isRecievedInvoicesSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document_invoices_activity);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);// if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();

        fab = (ImageView) findViewById(R.id.floatingActionButton);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new InvoicesAdapter(new ArrayList<Invoice>());
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        aSwitch = (Switch) findViewById(R.id.switch_docu);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isRecievedInvoicesSelected = isChecked;
            listInvoices();
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialog bottomsheetDialog = new BottomsheetDialog();
                bottomsheetDialog.show(getSupportFragmentManager(), bottomsheetDialog.getTag());
            }
        });
        img_arrow = (ImageView) findViewById(R.id.img_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DocumentInvoiceListActivity.this.finish();
            }
        });
        image_add_bond = (ImageView) findViewById(R.id.image_add_bond);
        image_add_bond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDocumentShipmentInvoiceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRecievedInvoicesSelected = true;
        listInvoices();
    }
    public void listInvoices() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.listInvoices("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<InvoicesData> data = (ResObj<InvoicesData>) response.body();
                    if (data.getStatus().equals("success")) {
                        if (isRecievedInvoicesSelected)
                            adapter.setData((ArrayList<Invoice>) data.getData().getInvoicesRecieved());
                        else
                            adapter.setData((ArrayList<Invoice>) data.getData().getInvoicesSent());

                    } else {
                        Toast.makeText(DocumentInvoiceListActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DocumentInvoiceListActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(DocumentInvoiceListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
