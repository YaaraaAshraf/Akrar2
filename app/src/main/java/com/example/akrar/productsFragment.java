package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class productsFragment extends Fragment {
  ImageView img_add,img_arrow;

    public productsFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_products, container, false);
        img_arrow=(ImageView)view.findViewById(R.id.image_my_productarrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
            }
        });

         img_add=(ImageView)view.findViewById(R.id.image_add);
          img_add.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  loadAddProducts(new FragmentAdd_product());
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
    private boolean loadAddProducts(Fragment fragment) {
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

