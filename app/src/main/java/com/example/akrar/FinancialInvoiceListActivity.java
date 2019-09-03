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
public class FinancialInvoiceListActivity extends AppCompatActivity {
    ImageView image_add_bond_cash, arow;
    ImageView fab;
    public RecyclerView recyclerView;
    FinancialAdapter adapter;
    InvoicesService invoicesService;
    AlertDialog loadingDialog;
    Switch aSwitch;
    boolean isRecievedInvoicesSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bond_cash_fragment);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();

        image_add_bond_cash = (ImageView) findViewById(R.id.image_add_bond_cash);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new FinancialAdapter(new ArrayList<Invoice>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        aSwitch = (Switch) findViewById(R.id.switch_fin);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isRecievedInvoicesSelected = isChecked;
            listInvoices();
        });
        fab = (ImageView) findViewById(R.id.floatingActionButton_cash);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialogCash bottomsheetDialog = new BottomsheetDialogCash();
                bottomsheetDialog.show(getSupportFragmentManager(), bottomsheetDialog.getTag());
            }
        });
        arow = (ImageView) findViewById(R.id.img_arrow);
        arow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        image_add_bond_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Add_Financial_Invoice.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        isRecievedInvoicesSelected = true;
        listInvoices();
    }

    public void applySearch(String name, String from, String to, String paytype){
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.filterFinancialInvoices("Bearer " + token, isRecievedInvoicesSelected?"0":"1",name,from,to,paytype);
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
                        Toast.makeText(FinancialInvoiceListActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(FinancialInvoiceListActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(FinancialInvoiceListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void listInvoices() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.listFinancialInvoices("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()){
                    ResObj<InvoicesData> data = (ResObj<InvoicesData>) response.body();
                    if (data.getStatus().equals("success")){
                        if (isRecievedInvoicesSelected)
                            adapter.setData((ArrayList<Invoice>) data.getData().getInvoicesRecieved());
                        else
                            adapter.setData((ArrayList<Invoice>) data.getData().getInvoicesSent());
                    } else {
                        Toast.makeText(FinancialInvoiceListActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(FinancialInvoiceListActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(FinancialInvoiceListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}