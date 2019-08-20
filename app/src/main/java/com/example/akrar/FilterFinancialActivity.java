package com.example.akrar;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.AddProductActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterFinancialActivity extends AppCompatActivity {
EditText txt_userid,edt_date,edt_datefrom;
Button button_search;
Spinner spinner;
InvoicesService invoicesService;
AlertDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_cash);

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(false); // if you want user to wait for some process to finish,
//        builder.setView(R.layout.loading_dialog_layout);
//        loadingDialog = builder.create();
//        invoicesService = ApiUtils.getInvoicesService();
//
//        txt_userid=(EditText)findViewById(R.id.txt_userid);
//        edt_date =(EditText)findViewById(R.id.edt_date);
//        edt_datefrom=(EditText)findViewById(R.id.edt_datefrom);
//        spinner=(Spinner)findViewById(R.id.spinner);
//        button_search=(Button) findViewById(R.id.button_searchfilter);
//        button_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"hhh",Toast.LENGTH_LONG).show();
////                filterSearch();
//            }
//        });
//
//    }
//    private void filterSearch() {
//        loadingDialog.show();
//        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
//        String token = userSharedPreferencesManager.getToken();
//        Call call = invoicesService.filtershipmentinvoice("Bearer " + token, txt_userid.getText().toString(),edt_date.getText().toString(),edt_datefrom.getText().toString());
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                loadingDialog.dismiss();
//                if (response.isSuccessful()) {
//                    ResObj resObj = (ResObj) response.body();
//                    if (resObj.getStatus().equals("success")) {
//                        Toast.makeText(FilterFinancialActivity.this.getApplicationContext(), "search...", Toast.LENGTH_SHORT).show();
//                        FilterFinancialActivity.this.finish();
//                    }
//                    else{
//                        Toast.makeText(FilterFinancialActivity.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                loadingDialog.dismiss();
//                Toast.makeText(FilterFinancialActivity.this.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}

