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

    public void expandable_layout_numid(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_numid);
        expandableLayout1_numid.toggle();
    }

    public void expandable_layout_address(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_address);
        expandableLayout1_address.toggle();
    }

    public void expandable_value(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1_value);
        expandableLayout1_value.toggle();
    }

    public void expandable_currency(View view) {
        expandableLayout_currrency = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_currrency);
        expandableLayout_currrency.toggle();
    }

    public void expandable_prod_one(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_prod_one);
        expandableLayout_prod_one.toggle();
    }

    public void expandable_desc(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_desc);
        expandableLayout_desc.toggle();
    }
}