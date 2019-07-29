package com.example.akrar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.akrar.R;

import java.util.Calendar;

public class FragmentBond extends AppCompatActivity {
    ImageView img_back,img_calender;
    EditText txt_date,edtext_sendto_bonds,edt_address_bonds,
            edt_name_of_product_bonds,text_quantity_bonds,
            text_value_bonds,text_date_bonds,text_description_bonds;
    Button btn_send;
    String st_date,st_sendto,st_address,st_productname,st_quantitiy,st_value,st_datebonds,st_desc;
    final Calendar c = Calendar.getInstance();
    final int year = c.get(Calendar.YEAR);
    final int month = c.get(Calendar.MONTH)+1;
    final int day = c.get(Calendar.DAY_OF_MONTH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragment_bond);
//    public FragmentBond(){
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState){
//        //Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_fragment_bond, container, false);
        edtext_sendto_bonds=(EditText)findViewById(R.id.edtext_sendto_bonds);
        edt_address_bonds=(EditText)findViewById(R.id.edt_address_bonds);
        edt_name_of_product_bonds=(EditText)findViewById(R.id.edt_name_of_product_bonds);
        text_quantity_bonds=(EditText)findViewById(R.id.text_quantity_bonds);
        text_date_bonds=(EditText)findViewById(R.id.text_date_bonds);
        text_value_bonds=(EditText)findViewById(R.id.text_value_bonds);
        text_description_bonds=(EditText)findViewById(R.id.text_description_bonds);
        btn_send=(Button)findViewById(R.id.btn_deliver_bonds);
        btn_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                st_date=txt_date.getText().toString();
//                 st_sendto=edtext_sendto_bonds.getText().toString();
//                 st_address=edt_address_bonds.getText().toString();
//                 st_productname=edt_name_of_product_bonds.getText().toString();
//                 st_quantitiy=text_quantity_bonds.getText().toString();
//                 st_value=text_value_bonds.getText().toString();
//                 st_desc=text_description_bonds.getText().toString();
//                FragmentTransaction transection=getFragmentManager().beginTransaction();
//                Document_Fragment mfragment=new Document_Fragment();
//                //using Bundle to send data
//                Bundle bundle=new Bundle();
//                bundle.putString("date",st_date);
//                bundle.putString("name",st_sendto);
//                bundle.putString("address",st_address);
//                bundle.putString("productname",st_productname);
//                bundle.putString("quantity",st_quantitiy);
//                bundle.putString("value",st_value);
//                bundle.putString("des",st_desc);
//                mfragment.setArguments(bundle); //data being send to SecondFragment
//                transection.replace(R.id.frame_container, mfragment);
//                transection.commit();
//              send(new salary_documents());
            }
        });

        img_calender=(ImageView)findViewById(R.id.image_calender);
        txt_date=(EditText)findViewById(R.id.text_date_bonds);
        img_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        txt_date.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                };
                DatePickerDialog dpDialog=new DatePickerDialog(getApplicationContext(), listener, year, month, day);
                dpDialog.show();
            }
        });
        img_back=(ImageView)findViewById(R.id.image_arrow_bond);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),  Document_Fragment.class);
                startActivity(intent);
//                back(new Mainpage_details());
            }
        });
//        return view;
    }
//    private boolean send(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
//    private boolean back(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
    }
//    }
