package com.example.akrar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class salary_documents extends Fragment {
    Button btn_deliver;
    ImageView img_arrow, img_calender;
    TextView text_date_docu, edtext_sendto_docu, edt_address, edt_name_of_product, text_quantity, text_value, text_description;
    String name;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH) + 1;
    final int day = c.get(Calendar.DAY_OF_MONTH);

    public salary_documents() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_salary_documents, container, false);
        img_arrow = (ImageView) view.findViewById(R.id.imgarrow);
        text_date_docu = (TextView) view.findViewById(R.id.text_date_docu);
        edtext_sendto_docu = (TextView) view.findViewById(R.id.edtext_sendto_docu);
        edt_address = (TextView) view.findViewById(R.id.edt_address);
        edt_name_of_product = (TextView) view.findViewById(R.id.edt_name_of_product);
        text_quantity = (TextView) view.findViewById(R.id.text_quantity);
        text_value = (TextView) view.findViewById(R.id.text_value);
        text_description = (TextView) view.findViewById(R.id.text_description);
        //retrieving data using bundle
        Bundle bundle = getArguments();

        text_date_docu.setText(String.valueOf(bundle.getString("date")));
        edtext_sendto_docu.setText(String.valueOf(bundle.getString("name")));
        edt_address.setText(String.valueOf(bundle.getString("address")));
        edt_name_of_product.setText(String.valueOf(bundle.getString("productname")));
        text_quantity.setText(String.valueOf(bundle.getString("quantity")));
        text_value.setText(String.valueOf(bundle.getString("value")));
        text_description.setText(String.valueOf(bundle.getString("des")));
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                back(new AddDocumentShipmentInvoiceActivity());
            }
        });
        img_calender = (ImageView) view.findViewById(R.id.img_calender);

        img_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        text_date_docu.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                };
                DatePickerDialog dpDialog = new DatePickerDialog(getActivity(), listener, year, month, day);
                dpDialog.show();
            }
        });
        btn_deliver = (Button) view.findViewById(R.id.btn_deliver);
        btn_deliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(getActivity(), "تاكيد استلام سند القبض العينى؟");
            }
        });
        return view;
    }

//    private boolean back(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
    public void showDialog(FragmentActivity activity, String s) {
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(s);

        Button dialogButton1 = (Button) dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button dialogButton2 = (Button) dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

