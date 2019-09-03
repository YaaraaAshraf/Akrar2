package com.example.akrar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.akrar.login_and_registration.LoginActivity;
import com.example.akrar.model.ApiUtils;
import com.example.akrar.model.LoginData;
import com.example.akrar.model.ResObj;
import com.example.akrar.model.UserService;
import com.example.akrar.products.ProductsListActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Mainpage_details extends Fragment {
    ImageView img_prod, image_gr, img_gm;
    Button btn_log;
    UserService userService;
    AlertDialog loadingDialog;
    private Mainpage_details myProjectListFragment;
    public Mainpage_details() {
    }
    public static Mainpage_details newInstance() {
        Mainpage_details emp = new Mainpage_details();
        return emp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mainpage_details, container, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false); // if you want user to wait for some process to finish,
        builder.setView(R.layout.loading_dialog_layout);
        loadingDialog = builder.create();
        userService = ApiUtils.getUserService();
        btn_log = (Button) view.findViewById(R.id.logout);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
//                 Intent intent=new Intent(getActivity(), LoginActivity.class);
//                 startActivity(intent);
            }
        });
        img_gm = (ImageView) view.findViewById(R.id.img_gm);
        img_gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FinancialInvoiceListActivity.class);
                startActivity(intent);
//                  loadbodnscash(new BondCashFragment());
            }
        });
        image_gr = (ImageView) view.findViewById(R.id.image_gr);
        image_gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DocumentInvoiceListActivity.class);
                startActivity(intent);
//                 loadBonds(new Document_shipment());
            }
        });
        img_prod = (ImageView) view.findViewById(R.id.img_pr);
        img_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ProductsListActivity.class);
                startActivity(intent);
//                   loadproduct(new ProductsListActivity());
            }
        });
        return view;
         }
               private void logout() {
                Call call = userService.logout("Bearer");
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
//                            ResObj resObj = (ResObj) response.body();
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                                Mainpage_details.this.getActivity().finish();
                            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Mainpage_details.this.getActivity().finish();
            }

//            private boolean load(Fragment fragment) {
//                if (fragment != null) {
//                    getFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.frame_container, fragment)
//                            .commit();
//                    return true;
//                }
//                return false;
//            }
//
//            private boolean loadBonds(Fragment fragment) {
//                if (fragment != null) {
//                    getFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.frame_container, fragment)
//                            .commit();
//                    return true;
//                }
//                return false;
//            }
//
//            private boolean loadproduct(Fragment fragment) {
//                if (fragment != null) {
//                    getFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.frame_container, fragment)
//                            .commit();
//                    return true;
//                }
//                return false;
//            }
        });
    }
}