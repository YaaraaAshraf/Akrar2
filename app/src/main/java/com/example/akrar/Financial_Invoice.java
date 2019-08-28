package com.example.akrar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.invoices.model.Invoice;
import com.example.akrar.invoices.model.InvoiceUser;
import com.example.akrar.invoices.model.InvoicesData;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.products.model.ProductData;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Financial_Invoice extends AppCompatActivity {
    TextView txt_id, address, value, currency, product_name, product_unit, product_qantity, product_price, txt_desciption;
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5;
    InvoicesService invoicesService;
    Invoice invoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial__invoice);
        invoicesService = ApiUtils.getInvoicesService();
        txt_id = (TextView) findViewById(R.id.txt_id);
        address = (TextView) findViewById(R.id.txt_address_invoice);
        value = (TextView) findViewById(R.id.txt_value);
        currency = (TextView) findViewById(R.id.txt_curr);
        product_name = (TextView) findViewById(R.id.txt_prod_one);
        product_unit = (TextView) findViewById(R.id.text_unit);
        product_qantity = (TextView) findViewById(R.id.text_value);
        product_price = (TextView) findViewById(R.id.text_prod_currency);
        txt_desciption = (TextView) findViewById(R.id.txt_description);
        showfinancialinvoice();
    }

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_numid);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_address);
        expandableLayout2.toggle();
    }
    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_value);
        expandableLayout3.toggle();
    }
    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_currrency);
        expandableLayout4.toggle();
    }
    public void expandableButton5(View view) {
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_prod_one);
        expandableLayout5.toggle();
    }
    private void showfinancialinvoice(){
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getApplicationContext().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = invoicesService.showfinancialpayment("Bearer " + token);
        call.enqueue(new Callback(){
            @Override
            public void onResponse(Call call,Response response){
                if (response.isSuccessful()){
                    ResObj<Invoice> resObj = (ResObj<Invoice>) response.body();
                    if (resObj.getStatus().equals("success")){
                        InvoiceUser invoiceUser=resObj.getData().getReceiver();
                        txt_id.setText(invoice.getReceiver().getNationalId());
//                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
//                        F user = resObj.getData().getInvoicesRecieved();
//                        txt_id.setText(user.getNationalID());
                          }else{
                        Toast.makeText(getApplicationContext(), " incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
        }
            @Override
            public void onFailure(Call call, Throwable t) {
            }
        });
    }
}
