package com.example.akrar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.akrar.invoices.InvoicesService;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.products.model.Product;
import com.example.akrar.products.model.ProductsService;

import java.util.ArrayList;
import java.util.Calendar;
public class CashReceipts extends AppCompatActivity {
ImageView image_arrow;
EditText editText_date,editText_value;
Button btn_add_payment,btn_send;
LinearLayout container;
RecyclerView recyclerView;
CashListAdapter adapter;
    InvoicesService invoicesService;
    ProductsService productsService;
    AlertDialog loadingDialog;
    ArrayList<String>listdata_cash;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH)+1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    int N=10;
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


//        editText_date = (EditText) findViewById(R.id.editText_date);
//        editText_value = (EditText) findViewById(R.id.editText_value);
        btn_add_payment = (Button) findViewById(R.id.btn_payments);
        btn_send=(Button)findViewById(R.id.btn_send);
         recyclerView=(RecyclerView)findViewById(R.id.cash_recycler);
        adapter = new CashListAdapter(new ArrayList<Rowitem_cash>());
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        container = (LinearLayout) findViewById(R.id.container);
        btn_add_payment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (N<=12){
                    adapter.addPayment(new Rowitem_cash("date","100"));
                }
                else {
                    Toast.makeText(getApplicationContext(),"notadd",Toast.LENGTH_LONG).show();
                }
//                LayoutInflater layoutInflater =
//                            (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    final View addView = layoutInflater.inflate(R.layout.row_cash_receipts, null);
//                EditText editText_date= (EditText) addView.findViewById(R.id.editText_date);
//                EditText edit_value = (EditText) addView.findViewById(R.id.edit_value);
//                 container.addView(addView,0);

                 {
                }
                }
        });
        image_arrow=(ImageView)findViewById(R.id.image_arrow);
        image_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CashReceipts.this, Add_Financial_Invoice.class);
                startActivity(intent);
            }
        });
    }
}
