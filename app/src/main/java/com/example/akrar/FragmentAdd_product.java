package com.example.akrar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.akrar.products.ProductsFragment;

public class FragmentAdd_product extends AppCompatActivity {
    ImageView image_product_arrow;
   Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
//    public FragmentAdd_product() {
//
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_add_product, container, false);
        btn_save=(Button)findViewById(R.id.btn_prod);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
         image_product_arrow=(ImageView)findViewById(R.id.image_product_arrow);
         image_product_arrow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), ProductsFragment.class);
                 startActivity(intent);
//                 back(new ProductsFragment());
             }
         });
//        return view;
    }
//    private boolean back(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
}

