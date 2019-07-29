package com.example.akrar;



import android.content.Intent;
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

import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile_Fragment extends Fragment {
    TextView txt_update;
    ImageView back_arrow;
    EditText edtext_name, edtext_mail, edtext_phone, text_national_id;
    String name, mail, phone, pass;
    Button btn_update;
    UserService userService;

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
        mail = edtext_mail.getText().toString();
        phone = edtext_phone.getText().toString();
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

        String username = edtext_name.getText().toString();
        String mail = edtext_mail.getText().toString();
        String phone = edtext_phone.getText().toString();
        String id = text_national_id.getText().toString();
        //validate form
        if (validateLogin(username, mail, phone, id)) {
            //do login
            doLogin(username, mail, phone, id);
        edtext_name = (EditText) view.findViewById(R.id.edtext_name_profile);
        edtext_mail = (EditText) view.findViewById(R.id.edtext_mail_profile);
        edtext_phone = (EditText) view.findViewById(R.id.edtext_phone_profile);
        text_national_id = (EditText) view.findViewById(R.id.national_id);
//        text_password=(EditText)view.findViewById(R.id.text_password_profile);
        btn_update = (Button) view.findViewById(R.id.btn_save);
        userService = ApiUtils.getUserService();




            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Update_MyProfileFragment.class);
                    startActivity(intent);
////                loadupdateFragment(new Update_MyProfileFragment());
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
            back_arrow = (ImageView) view.findViewById(R.id.image_back_arrow);
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
//            return view;
        }

//    private boolean loadupdateFragment(Fragment fragment) {
//        //switching fragment
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
        return view;
    }
    private void doLogin(String username, String mail, String phone, String id) {

        Call call = userService.user(username,mail,phone,id);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    ResObj resObj = (ResObj) response.body();
                    if (resObj.getStatus().equals("success")){
                        //login start main activity
//                        Intent intent = new Intent(Login.this, Main_bar.class);
//                        intent.putExtra("national_id", national_id);
//                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    Intent intent = new Intent(Login.this, Main_bar.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
//                    Toast.makeText(Login.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validateLogin(String username, String mail, String phone, String id) {
        if (username == null || username.trim().length() == 0) {
            Toast.makeText(getContext(), "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (username == null || mail.trim().length() == 0) {
            Toast.makeText(getContext(), "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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
}




