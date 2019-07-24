package com.example.akrar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Update_MyProfileFragment extends Fragment {

    ImageView back_arrow;
    Button btn_save;
    EditText edtext_name,edtext_mail_profile,edtext_phone_profile,text_password_profile,edt_retrypass_profile;
    public Update_MyProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_update__my_profile, container, false);
        edtext_name=(EditText)view.findViewById(R.id.edtext_name);
        edtext_mail_profile=(EditText)view.findViewById(R.id.edtext_mail_profile);
        edtext_phone_profile=(EditText)view.findViewById(R.id.edtext_phone_profile);
        text_password_profile=(EditText)view.findViewById(R.id.text_password_profile);
        edt_retrypass_profile=(EditText)view.findViewById(R.id.edt_retrypass_profile);

        btn_save=(Button)view.findViewById(R.id.btn_save_profile);
        back_arrow=(ImageView)view.findViewById(R.id.image_back_arrow_profile);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new profile_Fragment());
            }
        });
        return view;
    }

    private boolean back(Fragment fragment) {
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