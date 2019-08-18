package com.example.akrar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.login_and_registration.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Update_MyProfileFragment extends AppCompatActivity {
    ImageView back_arrow;
    Button btn_save;
    EditText edtext_firstname, edt_lastname, edtext_mail_profile, text_password_profile, edt_retrypass,edtext_phone_profile;
    TextView edt_id;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__my_profile);

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_update__my_profile, container, false);
        edtext_firstname = (EditText) findViewById(R.id.edtext_firstname);
        edt_lastname = (EditText) findViewById(R.id.lastname);
        edtext_mail_profile = (EditText) findViewById(R.id.mail);
        edtext_phone_profile = (EditText) findViewById(R.id.edtext_phone_profile);
        text_password_profile = (EditText) findViewById(R.id.text_password_profile);
        edt_retrypass = (EditText) findViewById(R.id.edt_retrypass_profile);
        edt_id = (TextView) findViewById(R.id.edtext_id);
        btn_save = (Button) findViewById(R.id.btn_save_profile);
        back_arrow = (ImageView) findViewById(R.id.image_back_arrow_profile);
        userService = ApiUtils.getUserService();
        doLogin();
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void doLogin() {
        UserSharedPreferencesManager userSharedPreferencesManager= UserSharedPreferencesManager.getInstance(this.getApplication().getApplicationContext());
        Call call = userService.user("Bearer "+userSharedPreferencesManager.getToken());
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    ResObj<LoginData> resObj = (ResObj<LoginData>) response.body();
                    if (resObj.getStatus().equals("success")){
                        //use this user to fill the fields you have
                        User editprofile = resObj.getData().getUser();
                        edtext_firstname.setText(editprofile.getFirstName());
                        edtext_mail_profile.setText(editprofile.getEmail());
                        edtext_phone_profile.setText(editprofile.getMobile());
                        edt_id.setText(editprofile.getNationalID());
                        edt_lastname.setText(editprofile.getLastName());

                    } else {
                        Toast.makeText(getApplicationContext(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("national_id", national_id);
//                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
//    private boolean back(Fragment fragment) {
//        if (fragment != null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }


