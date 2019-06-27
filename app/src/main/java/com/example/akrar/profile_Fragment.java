package com.example.akrar;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class profile_Fragment extends Fragment {
    TextView txt_update;
    ImageView back_arrow;
    public static profile_Fragment newInstance() {
        profile_Fragment emp = new profile_Fragment();
        return emp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        back_arrow=(ImageView)view.findViewById(R.id.image_back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
            }
        });
        txt_update = (TextView) view.findViewById(R.id.text_update);
        txt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadupdateFragment(new Update_MyProfileFragment());
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

    private boolean loadupdateFragment(Fragment fragment) {
        //switching fragment
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


