package com.example.akrar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.akrar.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Shipment_invoice extends AppCompatActivity {
    ExpandableRelativeLayout expandableLayout1_numid, expandableLayout1_address, expandableLayout1_value, expandableLayout_currrency, expandableLayout_prod_one, expandableLayout_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_invoice);
    }
    public void expandableButton1(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_numid);
        expandableLayout1_numid.toggle();
    }

    public void expandableButton2(View view) {
        expandableLayout1_address = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_address);
        expandableLayout1_address.toggle();
    }

    public void expandableButton3(View view) {
        expandableLayout1_value = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_value);
        expandableLayout1_value.toggle();
    }

    public void expandableButton4(View view) {
        expandableLayout_currrency = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_currrency);
        expandableLayout_currrency.toggle();
    }

    public void expandableButton5(View view) {
        expandableLayout_prod_one = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_prod_one);
        expandableLayout_prod_one.toggle();
    }

    public void expandableButton6(View view) {
        expandableLayout_desc = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_desc);
        expandableLayout_desc.toggle();
    }
}