package com.example.akrar.login_and_registration;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.example.akrar.model.Responseclass;
import com.example.akrar.model.UserService;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText edt_firstname, edt_lastname, edt_phone, edt_email, edt_password, edt_retrypass, edtext_national_id;
    Button btn_regiter;
    TextView txt_have_account;
    ImageButton img_arrow;
    UserService userService;
    AlertDialog loadingDialog;

    String device_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txt_have_account = (TextView) findViewById(R.id.txt_haveaccount);
        edt_firstname = (EditText) findViewById(R.id.edtext_firstname);
        edt_lastname = (EditText) findViewById(R.id.edtext_lastname);
        edtext_national_id = (EditText) findViewById(R.id.edtext_national_id);
        edt_phone = (EditText) findViewById(R.id.txtreg_phone);
        edt_email = (EditText) findViewById(R.id.edtext_email);
        edt_password = (EditText) findViewById(R.id.edtextreg_password);
        edt_retrypass = (EditText) findViewById(R.id.edtext_retry_password);
        btn_regiter = (Button) findViewById(R.id.btn_reg_now);
        img_arrow = findViewById(R.id.image_arrow);
        userService = ApiUtils.getUserService();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mainIntent = new Intent(RegistrationActivity.this, LoginActivity.class);
//                RegistrationActivity.this.startActivity(mainIntent);
                RegistrationActivity.this.finish();
            }
        });
        btn_regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = edt_firstname.getText().toString();
                String lastname = edt_lastname.getText().toString();
                String national_id = edtext_national_id.getText().toString();
                String phone = edt_phone.getText().toString();
                String mail = edt_email.getText().toString();
                String password = edt_password.getText().toString();
                String verifypass = edt_retrypass.getText().toString();
                FragmentTransaction transection = getFragmentManager().beginTransaction();
//                Document_shipment mfragment=new Document_shipment();
//                //using Bundle to send data
//                Bundle bundle=new Bundle();
//                bundle.putString("date",st_date);
//                bundle.putString("name",st_sendto);
//                bundle.putString("address",st_address);
//                bundle.putString("productname",st_productname);
//                bundle.putString("quantity",st_quantitiy);
//                bundle.putString("value",st_value);
//                bundle.putString("des",st_desc);
//                mfragment.setArguments(bundle); //data being send to SecondFragment
//                transection.replace(R.id.frame_container, mfragment);
//                transection.commit();
//              send(new salary_documents());

                //validate form
                if (validateregister(firstname, password, lastname, phone, mail, verifypass, national_id)) {

                    if(!password.equals(verifypass))
                        Toast.makeText(RegistrationActivity.this, "Password and confirmation password must be matching", Toast.LENGTH_SHORT).show();
                    else
                        doreg(firstname, lastname,national_id,mail,phone,  password, verifypass);

//                    Intent mainIntent = new Intent(RegistrationActivity.this, Mainpage_details.class);
//                    RegistrationActivity.this.startActivity(mainIntent);
//                    RegistrationActivity.this.finish();
                }
            }
        });
        txt_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrationActivity.this.finish();
            }

        });

        //FCM
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("FIREBASE_TOKEN", "getInstanceId failed", task.getException());
                        return;
                    }

                    // Get new Instance ID token
                    device_id = task.getResult().getToken();

                });
    }

    private boolean validateregister(String firstname, String password, String lastname, String phone, String mail, String verifypass, String national_id) {
        if (mail.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (national_id.isEmpty()){
            Toast.makeText(RegistrationActivity.this, "National ID is required", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void doreg(final String firstname, final String lastname, final String national_id, final String email, final String mobile, final String password, String password_confirmation) {

        loadingDialog.show();
        Call call = userService.createuser(firstname, lastname, national_id, email, mobile, password, password_confirmation,device_id);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()) {
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();

                    if(resObj.getStatus().equals("success")) {
                        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(RegistrationActivity.this.getApplicationContext());
                        userSharedPreferencesManager.saveToken(resObj.getData().getToken());
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    if (resObj.getStatus().equals("error")) {
                        Toast.makeText(RegistrationActivity.this, "The email or national id has already been taken", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(RegistrationActivity.this, "The national id has already been taken", Toast.LENGTH_SHORT).show();
                    }
//                    else{
//
//                    }
                } else {


                    try {
                        String errorBody = response.errorBody().string();
                        if(errorBody!= null) {
                            Gson gson = new Gson();
                            ResObj<LinkedTreeMap<String,ArrayList<String>>> error = gson.fromJson(errorBody, ResObj.class);

                            Map.Entry<String,ArrayList<String>> entry = error.getErrors().entrySet().iterator().next();
                            String key = entry.getKey();
                            ArrayList<String> value = entry.getValue();

                            Toast.makeText(RegistrationActivity.this, key+": "+value, Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(RegistrationActivity.this, "Registration failed! Please try again!!", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(RegistrationegistrationActivity.this, response.errorBody()!= null?response.errorBody().string():"Registration failed! Please try again!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                  Toast.makeText(RegistrationActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}




