package com.example.akrar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CashReceipts extends AppCompatActivity {
ImageView image_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_receipts);
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
