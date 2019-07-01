package com.example.akrar;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DocumentCash_Fragment extends Fragment {
   ImageView image_add_bond,img_arrow;
   ImageView fab;
    public DocumentCash_Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.document_fragment, container, false);
        fab=(ImageView) view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialog bottomsheetDialog=new BottomsheetDialog();
                bottomsheetDialog.show(getFragmentManager(),bottomsheetDialog.getTag());
            }
        });
        img_arrow=(ImageView)view.findViewById(R.id.img_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
            }
        });
        image_add_bond=(ImageView)view.findViewById(R.id.image_add_bond);
        image_add_bond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadBondFragment(new FragmentBond());
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

    private boolean loadBondFragment(Fragment fragment) {
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

