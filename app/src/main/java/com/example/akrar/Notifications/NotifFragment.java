package com.example.akrar.Notifications;


import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.akrar.MainActivity;
import com.example.akrar.Mainpage_details;
import com.example.akrar.NofificationAdapter;
import com.example.akrar.MyListData;
import com.example.akrar.R;
public class NotifFragment extends Fragment {
RecyclerView recyclerView;
ImageView arrow;

    public NotifFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notif, container, false);
        arrow=(ImageView)view.findViewById(R.id.image_product_arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
//                back(new Mainpage_details());
            }
        });

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        MyListData[] myListData = new MyListData[]{
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
        };
        NofificationAdapter adapter = new NofificationAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
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





