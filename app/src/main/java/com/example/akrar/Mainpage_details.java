package com.example.akrar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
public class Mainpage_details extends Fragment {
    ImageView img_prod,image_gr,img_gm;
    private Mainpage_details myProjectListFragment;
    public Mainpage_details() {
    }
    public static Mainpage_details newInstance() {
        Mainpage_details emp = new Mainpage_details();
        return emp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mainpage_details, container, false);
          img_gm=(ImageView)view.findViewById(R.id.img_gm);
          img_gm.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  loadbodnscash(new BondCashFragment());
              }
          });
         image_gr=(ImageView)view.findViewById(R.id.image_gr);
         image_gr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 loadBonds(new DocumentCash_Fragment());
             }
         });

           img_prod=(ImageView)view.findViewById(R.id.img_pr);
           img_prod.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   loadproduct(new productsFragment());
               }
           });
        return view;
    }

    private boolean loadbodnscash(Fragment fragment) {
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    private boolean loadBonds(Fragment fragment) {
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    private boolean loadproduct( Fragment fragment) {
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

