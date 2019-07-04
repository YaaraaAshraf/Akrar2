package com.example.akrar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class BottomsheetDialogCash extends BottomSheetDialogFragment  implements AdapterView.OnItemSelectedListener {
    EditText txt_dateTo,txt_datefrom,edt_datecash;
    Spinner spinner_deposite_cash;
    TextView txt_datecash;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH)+1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    String[] pay_type = {"كاش", "اجل"};
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentview=View.inflate(getContext(),R.layout.activity_filter_cash,null);
        dialog.setContentView(contentview);
        spinner_deposite_cash=(Spinner)contentview.findViewById(R.id.spinner_deposite_cash);
        txt_datecash=(TextView)contentview.findViewById(R.id.txt_datecash);
        spinner_deposite_cash.setOnItemSelectedListener(this);
        spinner_deposite_cash.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, pay_type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner_deposite_cash.setAdapter(aa);
        edt_datecash=(EditText)contentview.findViewById(R.id.edt_datecash);
        edt_datecash.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() <= edt_datecash.getTotalPaddingLeft()) {
                        // your action for drawable click event
                        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edt_datecash.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                            }
                        }, year, month, day);
                        datePicker.setTitle("Choose Date");
                        datePicker.show();
                        return true;
                    }
                }
                return false;
            }
        });
        txt_dateTo=(EditText)contentview.findViewById(R.id.edt_date);
        txt_datefrom=(EditText)contentview.findViewById(R.id.edt_datefrom);
        txt_datefrom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() <= txt_datefrom.getTotalPaddingLeft()) {
                        // your action for drawable click event
                        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txt_datefrom.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                            }
                        }, year, month, day);
                        datePicker.setTitle("Choose Date");
                        datePicker.show();
                        return true;
                    }
                }
                return false;
            }
        });

        txt_dateTo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() <= txt_dateTo.getTotalPaddingLeft()) {
                        // your action for drawable click event
                        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txt_dateTo.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                            }
                        }, year, month, day);
                        datePicker.setTitle("Choose Date");
                        datePicker.show();
                        return true;
                    }
                }
                return false;
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         if (spinner_deposite_cash.getSelectedItem().equals("كاش")) {
             edt_datecash.setVisibility(View.GONE);
//
         }else
             edt_datecash.setVisibility(View.VISIBLE);
//
        if (spinner_deposite_cash.getSelectedItem().equals("كاش")){
            txt_datecash.setVisibility(View.INVISIBLE);
        }else
            txt_datecash.setVisibility(View.VISIBLE);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
