package com.example.akrar.profile;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akrar.MainActivity;
import com.example.akrar.R;
import com.example.akrar.User;
import com.example.akrar.UserSharedPreferencesManager;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class profile_Fragment extends Fragment {
    TextView txt_update;
    ImageView back_arrow;
    TextView edtext_name, edtext_mail, edtext_phone, text_national_id;
    String name, mail, phone,id;
    Button btn_update;
    UserService userService;
    AlertDialog loadingDialog;

    public profile_Fragment() {
    }
    public void onResume() {
        super.onResume();
        doLogin();
//        edtext_name.setText(name);
//        edtext_mail.setText(mail);
//        edtext_phone.setText(phone);
//        text_password.setText(pass);
    }
    @Override
    public void onPause() {
        super.onPause();
//        name = edtext_name.getText().toString();
//        mail = edtext_mail.getText().toString();
//        phone = edtext_phone.getText().toString();
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

        edtext_name = (TextView) view.findViewById(R.id.text_name_profile);
        edtext_mail = (TextView) view.findViewById(R.id.edtext_mail_profile);
        edtext_phone = (TextView) view.findViewById(R.id.edtext_phone_profile);
        text_national_id = (TextView) view.findViewById(R.id.national_id);
        btn_update = (Button) view.findViewById(R.id.btn_save);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();

        userService = ApiUtils.getUserService();
//        String name = edtext_name.getText().toString();
//        String mail = edtext_mail.getText().toString();
//        String phone = edtext_phone.getText().toString();
//        String id = text_national_id.getText().toString();


        //validate form
//        if (validateLogin(name, mail, phone, id)) {
        {
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UpdateProfileActivity.class);
                startActivity(intent);
////                loadupdateFragment(new UpdateProfileActivity());
//                 Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
//                 Toast.makeText(getContext(), "Saved..", Toast.LENGTH_SHORT).show();
//                 name=edtext_name.getText().toString();
//                 mail=edtext_mail.getText().toString();
//                 phone=edtext_phone.getText().toString();
//                 pass=text_password.getText().toString();
//                 FragmentTransaction transection=getFragmentManager().beginTransaction();
//                    UpdateProfileActivity mfragment=new UpdateProfileActivity();
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
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
//                back(new Mainpage_details());
            }
        });
        }
        return view;
      }
    private void doLogin(){
        loadingDialog.show();
        UserSharedPreferencesManager userSharedPreferencesManager = UserSharedPreferencesManager.getInstance(this.getActivity().getApplicationContext());
        String token = userSharedPreferencesManager.getToken();
        Call call = userService.user("Bearer " + token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                loadingDialog.dismiss();
                if (response.isSuccessful()){
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();
                    if (resObj.getStatus().equals("success")) {
                        //use this user to fill the fields you have
                        User user = resObj.getData().getUser();
                        edtext_name.setText(user.getFirstName());
                        edtext_mail.setText(user.getEmail());
                        edtext_phone.setText(user.getMobile());
                        text_national_id.setText(user.getNationalID());
                    } else {
                        Toast.makeText(getContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                loadingDialog.dismiss();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


//    private boolean validateLogin(String username, String mail, String phone, String id) {
//        if (username == null || username.trim().length() == 0) {
//            Toast.makeText(getContext(), "Username is required", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (username == null || mail.trim().length() == 0) {
//            Toast.makeText(getContext(), "Password is required", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }
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




