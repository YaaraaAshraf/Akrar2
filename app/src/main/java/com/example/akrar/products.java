package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class products extends AppCompatActivity {
    ImageView img_add,image_my_productarrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        img_add=(ImageView)findViewById(R.id.image_add);
        image_my_productarrow=(ImageView)findViewById(R.id.image_my_productarrow);
        image_my_productarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(products.this,Mainpage_details.class);
                products.this.startActivity(mainIntent);
                products.this.finish();
            }
        });
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(products.this, Add_product.class);
                products.this.startActivity(mainIntent);
                products.this.finish();
            }
        });
    }
}
