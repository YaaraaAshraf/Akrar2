package com.example.akrar;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.Responseclass;
import com.example.akrar.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
    EditText edt_firstname, edt_lastname, edt_phone, edt_email, edt_password, edt_retrypass, edtext_national_id;
    Button btn_regiter;
    TextView txt_have_account;
    ImageView img_arrow;
    UserService userService;

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
        img_arrow = (ImageView) findViewById(R.id.image_arrow);
        userService = ApiUtils.getUserService();

        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Registration.this, Login.class);
                Registration.this.startActivity(mainIntent);
                Registration.this.finish();
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

                FragmentTransaction transection=getFragmentManager().beginTransaction();
//                Document_Fragment mfragment=new Document_Fragment();
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
                    //do login
                    doreg(firstname, password, lastname, phone, mail, verifypass, national_id);

//                    Intent mainIntent = new Intent(Registration.this, Mainpage_details.class);
//                    Registration.this.startActivity(mainIntent);
//                    Registration.this.finish();
                }
            }
        });
        txt_have_account.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    Intent mainIntent = new Intent(Registration.this, Login.class);
                                                    Registration.this.startActivity(mainIntent);
                                                    Registration.this.finish();
                                                }


                                            }
        );
    }

    private boolean validateregister(String firstname, String password, String lastname, String phone, String mail, String verifypass, String national_id) {
        if (mail.isEmpty()) {
            Toast.makeText(Registration.this, "Email is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(Registration.this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doreg(final String firstname, final String lastname, final String national_id, final String email, final String mobile, final String password, String password_confirmation) {

        Call call = userService.createuser(firstname, lastname, national_id, email, mobile, password, password_confirmation);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    Responseclass resObj = (Responseclass) response.body();
                    if (resObj.getStatus().equals("error")) {
                        Toast.makeText(Registration.this, "The email has already been taken", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Registration.this, "The email has already been taken", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intent intent = new Intent(Registration.this, Main_bar.class);
                    intent.putExtra("firstname", firstname);
                    intent.putExtra("lastname", lastname);
                    intent.putExtra("national_id", national_id);
                    intent.putExtra("email", email);
                    intent.putExtra("mobile", mobile);
                    intent.putExtra("password", password);
                    intent.putExtra("password_confirmation", password_confirmation);
                    startActivity(intent);
//                    Toast.makeText(Registration.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Registration.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}




