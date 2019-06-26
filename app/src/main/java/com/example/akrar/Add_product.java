package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Add_product extends AppCompatActivity {
    ImageView image_product_arrow;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        image_product_arrow=(ImageView)findViewById(R.id.image_product_arrow);
        image_product_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Add_product.this, products.class);
                Add_product.this.startActivity(mainIntent);
                Add_product.this.finish();
            }
        });
    }
}
