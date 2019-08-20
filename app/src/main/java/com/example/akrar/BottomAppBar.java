package com.example.akrar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.akrar.Notifications.NotifFragment;
import com.example.akrar.profile.profile_Fragment;

public class BottomAppBar extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//        ImageView img_notif, img_home, img_profile;
//        TextView txt_notif, txt_home, txt_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        //loading the default fragment
        loadFragment(new Mainpage_details());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation_view);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_main);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_main:
                fragment = new Mainpage_details();
                break;

            case R.id.navigation_notif:
                fragment = new NotifFragment();
                break;

            case R.id.navigation_profile:
                fragment = new profile_Fragment();
                break;
//
//            case R.id.navigation_profile:
//                fragment = new ProfileFragment();
//                break;
        }
        return loadFragment(fragment);
    }
    public boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}












































//        toolbar = getSupportActionBar();
//        // load the store fragment by default
//        toolbar.setTitle("Shop");
//        loadFragment(new Mainpage_details());
//    }
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment fragment;
//            switch (item.getItemId()) {
//                case R.id.navigation_main:
//                    toolbar.setTitle("Shop");
//                    fragment = new Mainpage_details();
//                    loadFragment(fragment);
//                    return true;
//                case R.id.navigation_profile:
//                    toolbar.setTitle("My Gifts");
//                    fragment = new GiftsFragment();
//                    loadFragment(fragment);
//                    return true;
////                case R.id.navigation_cart:
////                    toolbar.setTitle("Cart");
////                    fragment = new CartFragment();
////                    loadFragment(fragment);
////                    return true;
////                case R.id.navigation_notif:
////                    toolbar.setTitle("Profile");
////                    fragment = new ProfileFragment();
////                    loadFragment(fragment);
////                    return true;
////            }
//            }
//            return false;
//        }
//    };
//    public void loadFragment(Fragment fragment) {
//        // load fragment
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_container, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();



