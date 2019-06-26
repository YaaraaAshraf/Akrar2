package com.example.akrar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Mainpage_details extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    BottomNavigationView bottomNavigationView;
    ImageView img_pr, image_my_productarrow, image_add,img_gm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage_details);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_favourite);
        image_my_productarrow = (ImageView) findViewById(R.id.image_my_productarrow);
        img_gm=(ImageView)findViewById(R.id.img_gm);
        img_gm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Mainpage_details.this, Document.class);
                Mainpage_details.this.startActivity(mainIntent);
                Mainpage_details.this.finish();
            }
        });
        img_pr = (ImageView) findViewById(R.id.img_pr);
        img_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Mainpage_details.this, products.class);
                Mainpage_details.this.startActivity(mainIntent);
                Mainpage_details.this.finish();
            }
        });
    }

//    Mainpage_details accountFragment = new Mainpage_details();
//    Mainpage_details favouriteFragment = new Mainpage_details();
      Mainpage_profile storeFragment = new Mainpage_profile();
//    Cart cartFragment = new Cart();
//    Camera cameraFragment = new Camera();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_profile:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, storeFragment).commit();
                return true;

//            case R.id.navigation_profile:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container,storeFragment).commit();
//                return true;
//
//            case R.id.navigation_store:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, storeFragment).commit();
//                return true;
//
//            case R.id.navigation_cart:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, cartFragment).commit();
//                return true;
//
//            case R.id.navigation_camera:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, cameraFragment).commit();
//                return true;
//


        }
        return false;
    }
}



//    BottomNavigationView bottomNavigationView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mainpage_details);




//    AccountFragment accountFragment = new AccountFragment();
//   @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//          switch (item.getItemId()) {
//        case R.id.navigation_favourite:
//            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, accountFragment).commit();
//            return true;
//    }

//    return false;

//}



//        CurvedNavigationBottomView mView = findViewById(R.id.customBottomBar);
//        mView.inflateMenu(R.menu.bottom_menu);
//        mView.setSelectedItemId(R.id.action_schedules);
//        getting bottom navigation view and attaching the listener
//        mView.setOnNavigationItemSelectedListener(Mainpage_details.this);

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        return false;
//    }
//}







//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.action_favorites:
//                    break;
//                case R.id.action_schedules:
//                    break;
//                case R.id.action_music:
//                    break;
//            }
//            return true;

//
//    ImageView img_pr,img_gm,img_gr;
//    public Mainpage_details() {
//    }
//
//    public static androidx.fragment.app.Fragment newInstance() {
//        Mainpage_details offers = new Mainpage_details();
//        return offers;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_mainpage_details, container, false);
//          img_pr=(ImageView)view.findViewById(R.id.img_pr);
//         img_gm=(ImageView)view.findViewById(R.id.img_gm);
//        img_gr=(ImageView)view.findViewById(R.id.image_gr);
//        return view;
//    }
//}









