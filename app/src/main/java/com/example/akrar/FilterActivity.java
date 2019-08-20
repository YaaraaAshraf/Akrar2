package com.example.akrar;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.model.ApiUtils;

public class FilterActivity extends AppCompatActivity {
EditText txt_userid,edt_date,edt_datefrom;
Button button_search;
InvoicesService invoicesService;
AlertDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        invoicesService = ApiUtils.getInvoicesService();

        txt_userid=(EditText)findViewById(R.id.txt_userid);
        edt_date =(EditText)findViewById(R.id.edt_date);
        edt_datefrom=(EditText)findViewById(R.id.edt_datefrom);
        button_search=(Button) findViewById(R.id.button_search);



    }
}
