package com.example.akrar;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;
public class Update_MyProfileFragment extends AppCompatActivity {

    ImageView back_arrow;
    Button btn_save;
    EditText edtext_firstname,edt_lastname,edtext_mail_profile,edtext_phone_profile,text_password_profile,edt_retrypass,edt_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__my_profile);
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_update__my_profile, container, false);
        edtext_firstname=(EditText)findViewById(R.id.edtext_firstname);
        edtext_mail_profile=(EditText)findViewById(R.id.edtext_mail_profile);
        edtext_phone_profile=(EditText)findViewById(R.id.edtext_phone_profile);
        text_password_profile=(EditText)findViewById(R.id.text_password_profile);
        edt_retrypass=(EditText)findViewById(R.id.edt_retrypass_profile);
        edt_id=(EditText)findViewById(R.id.edtext_id);
        btn_save=(Button)findViewById(R.id.btn_save_profile);
        back_arrow=(ImageView)findViewById(R.id.image_back_arrow_profile);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), Main_bar.class);
                startActivity(intent);
//                back(new profile_Fragment());
            }
        });
    }

//
//    private boolean back(Fragment fragment) {
//        //switching fragment
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container,fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
}