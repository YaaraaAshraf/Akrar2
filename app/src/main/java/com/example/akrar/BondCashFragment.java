package com.example.akrar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class BondCashFragment extends AppCompatActivity {
    ImageView image_add_bond_cash, arow;
    ImageView fab;

//    public BondCashFragment() {
//        // Required empty public constructor
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bond_cash_fragment);
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.bond_cash_fragment, container, false);
        image_add_bond_cash = (ImageView) findViewById(R.id.image_add_bond_cash);
        fab = (ImageView) findViewById(R.id.floatingActionButton_cash);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialogCash bottomsheetDialog = new BottomsheetDialogCash();
                bottomsheetDialog.show(getSupportFragmentManager(), bottomsheetDialog.getTag());
            }
        });
        arow = (ImageView) findViewById(R.id.img_arrow);
        arow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
//                back(new Mainpage_details());
            }
        });
        image_add_bond_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Other_DocumentsCash.class);
                startActivity(intent);
//                loadcashbond(new Other_DocumentsCash());
            }
        });
//        return view;
    }

//    private boolean back(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
//
//    private boolean loadcashbond(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
    }
//}

