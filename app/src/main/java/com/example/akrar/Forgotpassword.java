package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Forgotpassword extends AppCompatActivity {
 ImageView img_arrow_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        img_arrow_back=(ImageView)findViewById(R.id.image_arrow);
        img_arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Forgotpassword.this,  Registration.class);
                Forgotpassword.this.startActivity(mainIntent);
                Forgotpassword.this.finish();
            }
        });
    }
}
