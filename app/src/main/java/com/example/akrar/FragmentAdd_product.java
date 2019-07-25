package com.example.akrar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentAdd_product extends Fragment {
    ImageView image_product_arrow;
   Button btn_save;
    public FragmentAdd_product() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_product, container, false);
        btn_save=(Button)view.findViewById(R.id.btn_prod);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
         image_product_arrow=(ImageView)view.findViewById(R.id.image_product_arrow);
         image_product_arrow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 back(new productsFragment());
             }
         });
        return view;
    }
    private boolean back(Fragment fragment) {
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

