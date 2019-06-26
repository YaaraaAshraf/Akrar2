package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class salary_documents extends AppCompatActivity {
Button btn_deliver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_documents);
        btn_deliver=(Button)findViewById(R.id.btn_deliver);
        btn_deliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(salary_documents.this,"تاكيد استلام سند القبض العينى؟");
            }
        });
    }

    public void showDialog(Activity activity, String msg){

        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

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
