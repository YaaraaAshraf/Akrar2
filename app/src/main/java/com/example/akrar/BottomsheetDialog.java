package com.example.akrar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

public class BottomsheetDialog extends BottomSheetDialogFragment {
    TextView txt_dateTo, txt_datefrom;
    Button search,clear;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH) + 1;
    final int day = c.get(Calendar.DAY_OF_MONTH);

    EditText name;
    Calendar from;
    Calendar to;

    private DatePickerDialog datePickerFrom;
    private DatePickerDialog datePickerTo;

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentview = View.inflate(getContext(), R.layout.activity_filter, null);
        dialog.setContentView(contentview);

        from = Calendar.getInstance();
        to = Calendar.getInstance();
        name = contentview.findViewById(R.id.edtext_namephone);

        txt_datefrom = contentview.findViewById(R.id.edt_date_from);
        txt_datefrom.setOnClickListener(v -> {
            datePickerFrom = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txt_datefrom.setText(year + "-" + month + "-" + dayOfMonth);
                    txt_dateTo.setText("");
                    to.clear();
                    from.set(Calendar.YEAR, year);
                    from.set(Calendar.MONTH, month);
                    from.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                }
            }, year, month, day);
            datePickerFrom.setCancelable(true);
            datePickerFrom.setCanceledOnTouchOutside(true);
            datePickerFrom.show();
        });

        txt_dateTo = contentview.findViewById(R.id.edt_dateto);
        txt_dateTo.setOnClickListener(v ->{
            datePickerTo = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txt_dateTo.setText(year + "-" + month + "-" + dayOfMonth);
                    to.set(Calendar.YEAR, year);
                    to.set(Calendar.MONTH, month);
                    to.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                }
            }, year, month, day);
            datePickerTo.getDatePicker().setMinDate(from.getTimeInMillis());
            datePickerTo.setCancelable(true);
            datePickerTo.setCanceledOnTouchOutside(true);
            datePickerTo.show();
        });

        clear = contentview.findViewById(R.id.button_clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DocumentInvoiceListActivity)getActivity()).onResume();
//                getActivity().getIntent().putExtra("name","");
//                getActivity().getIntent().putExtra("from","");
//                getActivity().getIntent().putExtra("to","");
                BottomsheetDialog.this.dismiss();

            }
        });
        search = contentview.findViewById(R.id.button_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DocumentInvoiceListActivity)getActivity()).applySearch(name.getText().toString(),txt_datefrom.getText().toString(),txt_dateTo.getText().toString());
//                getActivity().getIntent().putExtra("name",name.getText().toString());
//                getActivity().getIntent().putExtra("from",txt_dateTo.getText().toString());
//                getActivity().getIntent().putExtra("to",txt_dateTo.getText().toString());
                BottomsheetDialog.this.dismiss();
            }
        });
    }

}
