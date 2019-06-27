package com.example.akrar;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.akrar.R;

import java.util.Calendar;

public class FragmentBond extends Fragment {
    ImageView img_back,img_calender;
    EditText txt_date;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH)+1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    public FragmentBond(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_bond, container, false);
        img_calender=(ImageView)view.findViewById(R.id.image_calender);
        txt_date=(EditText)view.findViewById(R.id.text_date_bonds);
        img_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        txt_date.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }};
                DatePickerDialog dpDialog=new DatePickerDialog(getActivity(), listener, year, month, day);
                dpDialog.show();
            }
        });
        img_back=(ImageView)view.findViewById(R.id.image_arrow_bond);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
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
