package com.example.akrar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.CurrenciesData;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Financial_Invoice extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner_paytype;
    ImageView image_document_arrow;
    EditText desc;
    Button btn_send, btn_payments;
    TextView txt_document_pay, txt_value, txt_date;
    InvoicesService FinancialService;
//    InvoicesService invoicesService;
    AlertDialog loadingDialog;
    Spinner user_id;
    String[] pay_type = {"كاش", "اجل"};
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH) + 1;
    final int day = c.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_financial_invoice);
        FinancialService = ApiUtils.getInvoicesService();
//        FinancialService = ApiUtils.getInvoicesService();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        txt_document_pay = (TextView) findViewById(R.id.txt_document_pay);
        txt_value = (TextView) findViewById(R.id.txt_value);
        txt_date = (TextView) findViewById(R.id.txt_date);
        btn_payments = (Button) findViewById(R.id.button_addpayments);
        user_id=(Spinner)findViewById(R.id.edtext_send_to);
        desc=(EditText)findViewById(R.id.text_description);
        btn_payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Add_Financial_Invoice.this, CashReceipts.class);
                startActivity(intent);
            }
        });
//        edtext_value=(EditText)findViewById(R.id.text_value);
//        text_date_deposite=(EditText)findViewById(R.id.edt_date);
//        text_date_deposite.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_UP) {
//                    if(event.getRawX() <= text_date_deposite.getTotalPaddingLeft()) {
//                        // your action for drawable click event
//                        DatePickerDialog datePicker = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                                text_date_deposite.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
//                            }
//                        }, year, month, day);
//                        datePicker.setTitle("Choose Date");
//                        datePicker.show();
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });
        image_document_arrow = (ImageView) findViewById(R.id.image_document_arrow);
        image_document_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FinancialInvoiceListActivity.class);
                startActivity(intent);
            }
        });
        btn_send = (Button) findViewById(R.id.btn_send_to);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFinancialinvoice();
//                Intent intent = new Intent(getApplicationContext(), salary_documents.class);
//                startActivity(intent);
//                loadpage(new salary_documents());
            }
        });
        spinner_paytype = (Spinner) findViewById(R.id.spinner_paytype);
        spinner_paytype.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, pay_type);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner_paytype.setAdapter(aa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listShipmentInvoices();
    }

    public void listShipmentInvoices() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = FinancialService.listInvoices("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<InvoicesData> data = (ResObj<InvoicesData>) response.body();
                    if (data.getStatus().equals("success")) {

                        ShipmentInvoicesSpinnerAdapter currencySpinnerAdapter = new ShipmentInvoicesSpinnerAdapter(Add_Financial_Invoice.this,
                                R.layout.spinner_item, "Dollar");
                        ArrayList<Invoice> invoices = (ArrayList<Invoice>) data.getData().getInvoicesSent();
                        invoices.addAll(data.getData().getInvoicesRecieved());

                        currencySpinnerAdapter.setData(invoices);
                        user_id.setAdapter(currencySpinnerAdapter);
                    } else {
                        Toast.makeText(Add_Financial_Invoice.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Add_Financial_Invoice.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
//                listProducts();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(Add_Financial_Invoice.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addFinancialinvoice() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = FinancialService.add_financial_invoice("Bearer " + token,""+((Invoice)user_id.getSelectedItem()).getId(),""+spinner_paytype.getSelectedItemPosition(),desc.getText().toString());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
//                    ResObj<InvoicesData> data = (ResObj<InvoicesData>) response.body();
//                    if (data.getStatus().equals("success")) {
                        Toast.makeText(Add_Financial_Invoice.this.getApplicationContext(), " Added successfully!", Toast.LENGTH_SHORT).show();
                        Add_Financial_Invoice.this.finish();
//                    }
//                    else{
//                        Toast.makeText(Add_Financial_Invoice.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                    }
                }
                else{
                    Toast.makeText(Add_Financial_Invoice.this.getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(Add_Financial_Invoice.this.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (spinner_paytype.getSelectedItem().equals("اجل")) {
            btn_payments.setVisibility(View.VISIBLE);
            btn_send.setVisibility(View.GONE);
        } else
            btn_send.setVisibility(View.VISIBLE);

        if (spinner_paytype.getSelectedItem().equals("كاش")) {
            btn_send.setVisibility(View.VISIBLE);
            btn_payments.setVisibility(View.GONE);
        } else
            btn_send.setVisibility(View.GONE);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

