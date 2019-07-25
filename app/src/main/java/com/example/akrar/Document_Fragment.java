package com.example.akrar;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.ArrayList;

public class Document_Fragment extends Fragment {
   ImageView image_add_bond,img_arrow;
   ImageView fab;
   Switch aSwitch;
   public RecyclerView recyclerView;
   MyListAdapter_Bond myListAdapter_bond;
    public Document_Fragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.document_fragment, container, false);
        fab=(ImageView) view.findViewById(R.id.floatingActionButton);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        Bundle bundle = getArguments();

//       bundle.putString("date", String.valueOf(bundle));
        MyListData_Bond[] myListData = new MyListData_Bond[]{
                new MyListData_Bond("محمد بعتلك سند من قبض عيني","4444","011111"),
        };
        new MyListData_Bond("","","");
        MyListAdapter_Bond adapter = new MyListAdapter_Bond(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
//        editModelArrayList = populateList();
//        myListAdapter_bond = new MyListAdapter_Bond(getContext(),editModelArrayList);
////        MyListAdapter_Bond adapter = new MyListAdapter_Bond(myListData);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(myListAdapter_bond);

        aSwitch=(Switch)view.findViewById(R.id.switch_docu);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aSwitch.isChecked()){
                    back(new Document_Fragment());
                }else {
                    loadBondFragment(new BondCashFragment());
                }
            }
        });

//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (aSwitch.isChecked()) {
//                    back(new Document_Fragment());
//
//                } else
//                    {
//                    loadBondFragment(new BondCashFragment());
//                }
//
//            }
//        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialog bottomsheetDialog=new BottomsheetDialog();
                bottomsheetDialog.show(getFragmentManager(),bottomsheetDialog.getTag());
            }
        });
        img_arrow=(ImageView)view.findViewById(R.id.img_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
            }
        });
        image_add_bond=(ImageView)view.findViewById(R.id.image_add_bond);
        image_add_bond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBondFragment(new FragmentBond());
            }
        });
//        image_add_bond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadBondFragment(new FragmentBond());
//            }
//        });
        return view;
    }

//    private ArrayList<MyListData_Bond> populateList() {
//        ArrayList<MyListData_Bond> list = new ArrayList<>();
//
//        for(int i = 0; i < 8; i++){
//            MyListData_Bond editModel = new MyListData_Bond("","","");
//            editModel.setName(String.valueOf(i));
//            list.add(editModel);
//        }
//        return list;
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
    private boolean loadBondFragment(Fragment fragment) {
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
