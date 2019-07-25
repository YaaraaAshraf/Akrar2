package com.example.akrar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class profile_Fragment extends Fragment {
    TextView txt_update;
    ImageView back_arrow;
    EditText edtext_name,edtext_mail,edtext_phone,text_password;
    String name,mail,phone,pass;
    Button btnsave;
    public profile_Fragment() {
    }
    public void onResume() {
        super.onResume();
        edtext_name.setText(name);
        edtext_mail.setText(mail);
        edtext_phone.setText(phone);
//        text_password.setText(pass);
    }

    @Override
    public void onPause() {
        super.onPause();
        name = edtext_name.getText().toString();
        mail =edtext_mail.getText().toString();
        phone=edtext_phone.getText().toString();
//        pass=text_password.getText().toString();
    }
    public static profile_Fragment newInstance() {
        profile_Fragment emp = new profile_Fragment();
        return emp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        edtext_name=(EditText)view.findViewById(R.id.edtext_name);
        edtext_mail=(EditText)view.findViewById(R.id.edtext_mail_profile);
        edtext_phone=(EditText)view.findViewById(R.id.edtext_phone_profile);
//        text_password=(EditText)view.findViewById(R.id.text_password_profile);
         btnsave=(Button)view.findViewById(R.id.btn_save_profile);
         btnsave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 loadupdateFragment(new Update_MyProfileFragment());
//                 Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
//                 Toast.makeText(getContext(), "Saved..", Toast.LENGTH_SHORT).show();
//                 name=edtext_name.getText().toString();
//                 mail=edtext_mail.getText().toString();
//                 phone=edtext_phone.getText().toString();
//                 pass=text_password.getText().toString();
//                 FragmentTransaction transection=getFragmentManager().beginTransaction();
//                    Update_MyProfileFragment mfragment=new Update_MyProfileFragment();
//                 //using Bundle to send data
//                 Bundle bundle=new Bundle();
//                 bundle.putString("name",name);
//                 bundle.putString("phone",phone);
//                 bundle.putString("mail",mail);
//                 bundle.putString("pass",pass);
             }
         });
        back_arrow=(ImageView)view.findViewById(R.id.image_back_arrow_profile);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
            }
        });
//        txt_update = (TextView) view.findViewById(R.id.text_update);
//        txt_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadupdateFragment(new Update_MyProfileFragment());
//            }
//        });
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

    private boolean loadupdateFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}


