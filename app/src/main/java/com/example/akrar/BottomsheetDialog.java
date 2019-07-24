package com.example.akrar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;

public class BottomsheetDialog extends BottomSheetDialogFragment {
    EditText txt_dateTo,txt_datefrom;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH)+1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentview=View.inflate(getContext(),R.layout.activity_filter,null);
        dialog.setContentView(contentview);
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
}
