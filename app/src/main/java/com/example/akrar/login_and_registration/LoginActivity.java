package com.example.akrar.login_and_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.akrar.MainActivity;
import com.example.akrar.R;
import com.example.akrar.UserSharedPreferencesManager;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edt_mail, edt_password;
    Button btn_login;
    TextView txt_create_account, txt_forgetpass;
    UserService userService;
    AlertDialog loadingDialog;
    ImageButton img_arrow_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txt_create_account = (TextView) findViewById(R.id.txt_createaccount);
        edt_mail = (EditText) findViewById(R.id.edtext_mailreg);
        edt_password = (EditText) findViewById(R.id.edtext_password);
        btn_login = (Button) findViewById(R.id.btn_reg);
        txt_forgetpass = (TextView) findViewById(R.id.txt_forgotpass);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        userService = ApiUtils.getUserService();


        img_arrow_back = findViewById(R.id.image_arrow);
        img_arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mainIntent = new Intent(ForgotpasswordActivity.this, RegistrationActivity.class);
//                ForgotpasswordActivity.this.startActivity(mainIntent);
                LoginActivity.this.finish();
            }
        });

        txt_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                LoginActivity.this.startActivity(mainIntent);
//                LoginActivity.this.finish();
            }
        });
        txt_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LoginActivity.this, ForgotpasswordActivity.class);
                LoginActivity.this.startActivity(mainIntent);
//                LoginActivity.this.finish();
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
//                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
//                LoginActivity.this.startActivity(mainIntent);
//                LoginActivity.this.finish();
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

        loadingDialog.show();



        Call call = userService.login(national_id, password);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();
                    if (resObj.getStatus().equals("success")) {

//                  Toast.makeText(LoginActivity.this, "Token:"+ ((LoginData)resObj.getData()).getToken(), Toast.LENGTH_SHORT).show();
                        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(LoginActivity.this.getApplicationContext());
                        userSharedPreferencesManager.saveToken(resObj.getData().getToken());

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("national_id", national_id);
                        startActivity(intent);

                        //login start main activity
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        intent.putExtra("national_id", national_id);
//                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("national_id", national_id);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        intent.putExtra("national_id", national_id);
//                startActivity(intent);
            }
        });
    }
}





