package com.example.akrar.login_and_registration;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.akrar.R;

public class ForgotpasswordActivity extends AppCompatActivity {
    ImageButton img_arrow_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        img_arrow_back = findViewById(R.id.image_arrow);
        img_arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mainIntent = new Intent(ForgotpasswordActivity.this, RegistrationActivity.class);
//                ForgotpasswordActivity.this.startActivity(mainIntent);
                ForgotpasswordActivity.this.finish();
            }
        });
    }
}
