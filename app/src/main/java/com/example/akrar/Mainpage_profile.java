package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Mainpage_profile extends Fragment {
    TextView txt_update;
    public static Mainpage_profile newInstance() {
        Mainpage_profile emp = new Mainpage_profile();
        return emp;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mainpage, container, false);





return view;






//          txt_update=(TextView)findViewById(R.id.text_update);
//          txt_update.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  Intent mainIntent = new Intent(Mainpage_profile.this, Update_MyProfile.class);
//                  Mainpage_profile.this.startActivity(mainIntent);
//                  Mainpage_profile.this.finish();
//              }
//          });
    }
}
