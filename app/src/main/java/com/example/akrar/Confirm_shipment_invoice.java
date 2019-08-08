package com.example.akrar;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.akrar.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Confirm_shipment_invoice extends AppCompatActivity {
    ExpandableRelativeLayout expandableLayout1_numid, expandableLayout1_address, expandableLayout1_value, expandableLayout_currrency, expandableLayout_prod_one, expandableLayout_desc;
    Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_shipment_invoice);
    }
    public void expandable_layout_numid(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_numid);
        expandableLayout1_numid.toggle();
    }

    public void expandable_layout_address(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_address);
        expandableLayout1_address.toggle();
    }

    public void expandable_value(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_value);
        expandableLayout1_value.toggle();
    }

    public void expandable_currency(View view) {
        expandableLayout_currrency = (ExpandableRelativeLayout) findViewById(R.id.Layout_currrency);
        expandableLayout_currrency.toggle();
    }

    public void expandable_prod_one(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.Layout_prod_one);
        expandableLayout_prod_one.toggle();
    }

    public void expandable_desc(View view) {
        expandableLayout1_numid = (ExpandableRelativeLayout) findViewById(R.id.Layout_desc);
        expandableLayout_desc.toggle();

        btn_confirm=(Button)findViewById(R.id.btn_deliver);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getApplicationContext(), "تاكيد استلام سند القبض العينى؟");
            }
        });
    }

    private void showDialog(Context applicationContext, String s) {
        final Dialog dialog = new Dialog(applicationContext, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
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