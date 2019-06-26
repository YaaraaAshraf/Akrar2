package com.example.akrar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.accounts.Account;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.akrar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_bar extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_bar);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//
//        bottomNavigationView.setSelectedItemId(R.id.navigation_store);
//
//    }
//
//    Mainpage_details accountFragment = new Mainpage_details();
//    Mainpage_details favouriteFragment = new Mainpage_details();
////    Store storeFragment = new Store();
////    Cart cartFragment = new Cart();
////    Camera cameraFragment = new Camera();
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.navigation_account:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, accountFragment).commit();
//                return true;

//            case R.id.navigation_favourite:
//                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R.id.container, favouriteFragment).commit();
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
}
