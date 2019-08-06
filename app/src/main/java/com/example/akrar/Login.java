package com.example.akrar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText edt_mail, edt_password;
    Button btn_login;
    TextView txt_create_account, txt_forgetpass;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txt_create_account = (TextView) findViewById(R.id.txt_createaccount);
        edt_mail = (EditText) findViewById(R.id.edtext_mailreg);
        edt_password = (EditText) findViewById(R.id.edtext_password);
        btn_login = (Button) findViewById(R.id.btn_reg);
        txt_forgetpass = (TextView) findViewById(R.id.txt_forgotpass);
        userService = ApiUtils.getUserService();
        txt_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Login.this, Registration.class);
                Login.this.startActivity(mainIntent);
                Login.this.finish();
            }
        });
        txt_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Login.this, Registration.class);
                Login.this.startActivity(mainIntent);
                Login.this.finish();
            }
        });
        txt_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Login.this, Forgotpassword.class);
                Login.this.startActivity(mainIntent);
                Login.this.finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_mail.getText().toString();
                String password = edt_password.getText().toString();
                //validate form
                if (validateLogin(username, password)) {
                    //do login
                    doLogin(username, password);
//                Intent mainIntent = new Intent(Login.this, Main_bar.class);
//                Login.this.startActivity(mainIntent);
//                Login.this.finish();
                }
            }
        });
    }
    private boolean validateLogin(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void doLogin(final String national_id, final String password) {
        Call call = userService.login(national_id, password);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();
                    if (resObj.getStatus().equals("success")) {

//                  Toast.makeText(Login.this, "Token:"+ ((LoginData)resObj.getData()).getToken(), Toast.LENGTH_SHORT).show();
                        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(Login.this.getApplicationContext());
                        userSharedPreferencesManager.saveToken(resObj.getData().getToken());

                        Intent intent = new Intent(Login.this, Main_bar.class);
                        intent.putExtra("national_id", national_id);
                        startActivity(intent);

                        //login start main activity
//                        Intent intent = new Intent(Login.this, Main_bar.class);
//                        intent.putExtra("national_id", national_id);
//                        startActivity(intent);

                    } else {
                        Toast.makeText(Login.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    Intent intent = new Intent(Login.this, Main_bar.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
                    Toast.makeText(Login.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}





