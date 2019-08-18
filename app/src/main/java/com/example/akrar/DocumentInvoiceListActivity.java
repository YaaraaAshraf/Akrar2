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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document_invoices_activity);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();


        fab = (ImageView) findViewById(R.id.floatingActionButton);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        Bundle bundle = getArguments();

//       bundle.putString("date", String.valueOf(bundle));
//        Invoice[] myListData = new Invoice[]{
//                new Invoice("محمد بعتلك سند من قبض عيني","4444","011111"),
//        };
//        new Invoice("","","");
        adapter = new InvoicesAdapter(new ArrayList<Invoice>());
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        aSwitch = (Switch) findViewById(R.id.switch_docu);
//        aSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (aSwitch.isChecked()){
//                    back(new DocumentInvoiceListActivity());
//                }else {
//                    loadBondFragment(new BondCashFragment());
//                }
//            }
//        });

//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (aSwitch.isChecked()) {
//                    back(new DocumentInvoiceListActivity());
//
//                } else
//                    {
//                    loadBondFragment(new BondCashFragment());
//                }
//
//            }
//        });
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
                Intent intent = new Intent(getApplicationContext(), AddShimpment_invoice.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
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

                        adapter.setData((ArrayList<Invoice>) data.getData().getInvoicesSent());

//                  Toast.makeText(LoginActivity.this, "Token:"+ ((LoginData)resObj.getData()).getToken(), Toast.LENGTH_SHORT).show();
//                        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(LoginActivity.this.getApplicationContext());
//                        userSharedPreferencesManager.saveToken(resObj.getData().getToken());
//
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        intent.putExtra("national_id", national_id);
//                        startActivity(intent);

                        //login start main activity
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        intent.putExtra("national_id", national_id);
//                        startActivity(intent);

//                    } else {
//                        Toast.makeText(LoginActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
//                    }
                    } else {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
//                    Toast.makeText(LoginActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(DocumentInvoiceListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        intent.putExtra("national_id", national_id);
//                startActivity(intent);
            }
        });
    }
}
