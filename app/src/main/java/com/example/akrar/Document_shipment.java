package com.example.akrar;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class Document_shipment extends AppCompatActivity {
   ImageView image_add_bond,img_arrow;
   ImageView fab;
   Switch aSwitch;
   public RecyclerView recyclerView;
   MyListAdapter_Bond myListAdapter_bond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document_fragment);
//    public Document_shipment(){
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view= inflater.inflate(R.layout.document_fragment, container, false);
        fab=(ImageView) findViewById(R.id.floatingActionButton);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
//        Bundle bundle = getArguments();

//       bundle.putString("date", String.valueOf(bundle));
        MyListData_Bond[] myListData = new MyListData_Bond[]{
                new MyListData_Bond("محمد بعتلك سند من قبض عيني","4444","011111"),
        };
        new MyListData_Bond("","","");
        MyListAdapter_Bond adapter = new MyListAdapter_Bond(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
//        editModelArrayList = populateList();
//        myListAdapter_bond = new MyListAdapter_Bond(getContext(),editModelArrayList);
////        MyListAdapter_Bond adapter = new MyListAdapter_Bond(myListData);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(myListAdapter_bond);

        aSwitch=(Switch)findViewById(R.id.switch_docu);
//        aSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (aSwitch.isChecked()){
//                    back(new Document_shipment());
//                }else {
//                    loadBondFragment(new FinancialInvoiceListActivity());
//                }
//            }
//        });

//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (aSwitch.isChecked()) {
//                    back(new Document_shipment());
//
//                } else
//                    {
//                    loadBondFragment(new FinancialInvoiceListActivity());
//                }
//
//            }
//        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialog bottomsheetDialog=new BottomsheetDialog();
                bottomsheetDialog.show(getSupportFragmentManager(),bottomsheetDialog.getTag());
            }
        });
        img_arrow=(ImageView)findViewById(R.id.img_arrow);
        img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
//                back(new Mainpage_details());
            }
        });
        image_add_bond=(ImageView)findViewById(R.id.image_add_bond);
        image_add_bond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDocumentShipmentInvoiceActivity.class);
                startActivity(intent);
//                loadBondFragment(new AddDocumentShipmentInvoiceActivity());
            }
        });
//        image_add_bond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadBondFragment(new AddDocumentShipmentInvoiceActivity());
//            }
//        });
//        return view;
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
//    private boolean loadBondFragment(Fragment fragment) {
//        if (fragment != null) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.frame_container, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }

    }
