package com.example.akrar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Register extends AppCompatActivity {
    EditText edt_mail, edt_password;
    Button btn_reg;
    TextView txt_create_account, txt_forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        txt_create_account = (TextView) findViewById(R.id.txt_createaccount);
        edt_mail = (EditText) findViewById(R.id.edtext_mailreg);
        edt_password = (EditText) findViewById(R.id.edtext_password);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        txt_forgetpass = (TextView) findViewById(R.id.txt_forgotpass);
            txt_create_account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainIntent = new Intent(Register.this, Registration.class);
                    Register.this.startActivity(mainIntent);
                    Register.this.finish();
                }
            });
        txt_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Register.this, Forgotpassword.class);
                Register.this.startActivity(mainIntent);
                Register.this.finish();
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                Intent mainIntent = new Intent(Register.this, Main_bar.class);
                Register.this.startActivity(mainIntent);
                Register.this.finish();

                txt_create_account.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent mainIntent = new Intent(Register.this, Registration.class);
                        Register.this.startActivity(mainIntent);
                        Register.this.finish();
                    }
                });
            }
        });
    }
}

