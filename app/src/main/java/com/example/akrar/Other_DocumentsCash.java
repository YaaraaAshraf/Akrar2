package com.example.akrar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Other_DocumentsCash extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinner_paytype, spi_deposite;
    ImageView image_document_arrow;
    EditText text_date_deposite,edt_date,edtext_value;
    Button btn_send;
    TextView txt_document_pay,txt_value,txt_date;
    String[] pay_type = {"كاش", "اجل"};
    String[] deposite_type = {"نعم", "لا"};
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH)+1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    public Other_DocumentsCash() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_document_send_cash, container, false);
        txt_document_pay=(TextView)view.findViewById(R.id.txt_document_pay);
        txt_value=(TextView)view.findViewById(R.id.txt_value);
        txt_date=(TextView)view.findViewById(R.id.txt_date);
        edtext_value=(EditText)view.findViewById(R.id.text_value);
        text_date_deposite=(EditText)view.findViewById(R.id.edt_date);
        text_date_deposite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() <= text_date_deposite.getTotalPaddingLeft()) {
                        // your action for drawable click event
                        DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                text_date_deposite.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
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
        image_document_arrow = (ImageView) view.findViewById(R.id.image_document_arrow);
        image_document_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new BondCashFragment());
            }
        });
        btn_send = (Button) view.findViewById(R.id.btn_send_to);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadpage(new salary_documents());
            }
        });
        spinner_paytype = (Spinner) view.findViewById(R.id.spinner_paytype);

        spi_deposite = (Spinner) view.findViewById(R.id.spinner_deposite);
        spinner_paytype.setOnItemSelectedListener(this);
        spi_deposite.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, pay_type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner_paytype.setAdapter(aa);
        ArrayAdapter deposite = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, deposite_type);
        deposite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_deposite.setAdapter(deposite);
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

    private boolean loadpage(Fragment fragment) {
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (spinner_paytype.getSelectedItem().equals("اجل")){
             spi_deposite.setVisibility(View.VISIBLE);
        }else
            spi_deposite.setVisibility(View.GONE);
        if (spinner_paytype.getSelectedItem().equals("اجل")){
            txt_document_pay.setVisibility(View.VISIBLE);
        }else
            txt_document_pay.setVisibility(View.GONE);
        if (spinner_paytype.getSelectedItem().equals("اجل")){
            txt_value.setVisibility(View.VISIBLE);
        }else
            txt_value.setVisibility(View.GONE);
        if (spinner_paytype.getSelectedItem().equals("اجل")){
            edtext_value.setVisibility(View.VISIBLE);
        }else
            edtext_value.setVisibility(View.GONE);
        if (spinner_paytype.getSelectedItem().equals("اجل")){
            text_date_deposite.setVisibility(View.VISIBLE);
        }else
        text_date_deposite.setVisibility(View.GONE);
        if (spinner_paytype.getSelectedItem().equals("اجل")){
            txt_date.setVisibility(View.VISIBLE);
        }else
        txt_date.setVisibility(View.GONE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

