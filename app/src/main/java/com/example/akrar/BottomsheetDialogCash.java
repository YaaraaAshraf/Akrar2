package com.example.akrar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class BottomsheetDialogCash extends BottomSheetDialogFragment implements AdapterView.OnItemSelectedListener {
    EditText txt_userid;
    Spinner spinner_cash;
    TextView txt_datecash;
    TextView txt_dateTo, txt_datefrom;
    TextView txtdateTo, txtdatefrom;
    Button search,clear;
    Button btn_search;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH) + 1;
    final int day = c.get(Calendar.DAY_OF_MONTH);

    EditText name;
    Calendar from;
    Calendar to;

    private DatePickerDialog datePickerFrom;
    private DatePickerDialog datePickerTo;
    String[] pay_type = {"كاش", "اجل"};
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentview=View.inflate(getContext(),R.layout.activity_filter_cash,null);
        dialog.setContentView(contentview);
        from = Calendar.getInstance();
        to = Calendar.getInstance();
        txt_userid=contentview.findViewById(R.id.edtext_id);

       name=(EditText)contentview.findViewById(R.id.edtext_id);
        btn_search = (Button) contentview.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FinancialInvoiceListActivity) getActivity()).applySearch(name.getText().toString(), txt_datefrom.getText().toString(), txt_dateTo.getText().toString(),spinner_cash.getSelectedItem().toString());
//                getActivity().getIntent().putExtra("name",name.getText().toString());
//                getActivity().getIntent().putExtra("from",txt_dateTo.getText().toString());
//                getActivity().getIntent().putExtra("to",txt_dateTo.getText().toString());
                BottomsheetDialogCash.this.dismiss();
//                Toast.makeText(getContext(),"gggg",Toast.LENGTH_LONG).show();
            }
        });
        txt_datefrom=contentview.findViewById(R.id.edt_datefrom);
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
        txt_dateTo=contentview.findViewById(R.id.edt_date);
        txt_dateTo.setOnClickListener(v -> {
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

                spinner_cash = (Spinner) contentview.findViewById(R.id.spinner_cash);
//        txt_datecash=(TextView)contentview.findViewById(R.id.txt_datecash);
//        spinner_deposite_cash.setOnItemSelectedListener(this);
                spinner_cash.setOnItemSelectedListener(this);
                ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, pay_type);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Setting the ArrayAdapter data on the Spinner
                spinner_cash.setAdapter(aa);
            }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//         if (spinner_deposite_cash.getSelectedItem().equals("كاش")) {
//             edt_datecash.setVisibility(View.GONE);
////
//         }else
//             edt_datecash.setVisibility(View.VISIBLE);
////
//        if (spinner_deposite_cash.getSelectedItem().equals("كاش")){
//            txt_datecash.setVisibility(View.INVISIBLE);
//        }else
//            txt_datecash.setVisibility(View.VISIBLE);
//    }
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//    }
}
