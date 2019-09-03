package com.example.akrar.profile;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akrar.MainActivity;
import com.example.akrar.R;
import com.example.akrar.User;
import com.example.akrar.UserSharedPreferencesManager;
import com.example.akrar.login_and_registration.RegistrationActivity;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class UpdateProfileActivity extends AppCompatActivity {
    ImageView back_arrow;
    Button btn_save;
    EditText edtext_firstname, edt_lastname, edtext_mail_profile, text_password_profile, edt_retrypass,edtext_phone_profile;
    TextView edt_id;
    UserService userService;
    AlertDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__my_profile);

        edtext_firstname = (EditText) findViewById(R.id.edtext_firstname);
        edt_lastname = (EditText) findViewById(R.id.lastname);
        edtext_mail_profile = (EditText) findViewById(R.id.mail);
        edtext_phone_profile = (EditText) findViewById(R.id.edtext_phone_profile);
        text_password_profile = (EditText) findViewById(R.id.text_password_profile);
        edt_retrypass = (EditText) findViewById(R.id.edt_retrypass_profile);
        edt_id = (TextView) findViewById(R.id.edtext_id);
        edt_id.setEnabled(false);
        btn_save = (Button) findViewById(R.id.btn_save_profile);
        back_arrow = (ImageView) findViewById(R.id.image_back_arrow_profile);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();

        userService = ApiUtils.getUserService();
         doLogin();
         btn_save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(!text_password_profile.getText().toString().equals(edt_retrypass.getText().toString())) {
                     Toast.makeText(getApplicationContext(), "The password and confirm password do not match", Toast.LENGTH_SHORT).show();
                 }
                 else
                     updateProfile();
             }
         });
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void doLogin() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(this.getApplication().getApplicationContext());
        Call call = userService.user("Bearer "+userSharedPreferencesManager.getToken());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    loadingDialog.dismiss();
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();
                    if (resObj.getStatus().equals("success")){
                        //use this user to fill the fields you have
                        User editprofile = resObj.getData().getUser();
                        edtext_firstname.setText(editprofile.getFirstName());
                        edtext_mail_profile.setText(editprofile.getEmail());
                        edtext_phone_profile.setText(editprofile.getMobile());
                        edt_id.setText(editprofile.getNationalID());
                        edt_lastname.setText(editprofile.getLastName());

                    } else {
                        Toast.makeText(getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    loadingDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateProfile() {
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(this.getApplication().getApplicationContext());
        Call call = userService.editprofile("Bearer "+userSharedPreferencesManager.getToken(),edtext_firstname.getText().toString(),
                edt_lastname.getText().toString(),edt_id.getText().toString(),edtext_mail_profile.getText().toString(),edtext_phone_profile.getText().toString(),
                text_password_profile.getText().toString().isEmpty()?null:text_password_profile.getText().toString(),edt_retrypass.getText().toString().isEmpty()?null:edt_retrypass.getText().toString());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();
                    if (resObj.getStatus().equals("success")){
                        Toast.makeText(getApplicationContext(), "Profile updated successfully", Toast.LENGTH_SHORT).show();
                        UpdateProfileActivity.this.finish();
                        //use this user to fill the fields you have
//                        User editprofile = resObj.getData().getUser();
//                        edtext_firstname.setText(editprofile.getFirstName());
//                        edtext_mail_profile.setText(editprofile.getEmail());
//                        edtext_phone_profile.setText(editprofile.getMobile());
//                        edt_id.setText(editprofile.getNationalID());
//                        edt_lastname.setText(editprofile.getLastName());

                    } else {
                        Toast.makeText(getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    loadingDialog.dismiss();
                    try {
                        Toast.makeText(UpdateProfileActivity.this, response.errorBody()!= null?response.errorBody().string():"Error! Please try again!", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    Toast.makeText(getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

