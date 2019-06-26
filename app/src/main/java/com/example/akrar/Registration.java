package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
EditText edt_firstname,edt_lastname,edt_phone,edt_email,edt_password,edt_retrypass;
Button btn_regiter;
TextView txt_have_account;
ImageView img_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txt_have_account=(TextView)findViewById(R.id.txt_haveaccount);
        edt_firstname=(EditText)findViewById(R.id.edtext_firstname);
        edt_lastname=(EditText)findViewById(R.id.edtext_lastname);
        edt_phone=(EditText)findViewById(R.id.edtext_phone);
        edt_email=(EditText)findViewById(R.id.edtext_email);
        edt_password=(EditText)findViewById(R.id.edtext_password);
        edt_retrypass=(EditText)findViewById(R.id.edtext_retry_password);
        btn_regiter=(Button)findViewById(R.id.btn_reg_now);
        img_arrow=(ImageView)findViewById(R.id.image_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Registration.this,  Register.class);
                Registration.this.startActivity(mainIntent);
                Registration.this.finish();
            }
        });
        btn_regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Registration.this, Mainpage_details.class);
                Registration.this.startActivity(mainIntent);
                Registration.this.finish();
            }
        });
        txt_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Registration.this, Register.class);
                Registration.this.startActivity(mainIntent);
                Registration.this.finish();
            }
        });
    }
}