package com.example.akrar;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
                back(new Mainpage_details());
            }
        });

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        MyListData[] myListData = new MyListData[]{
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),
                new MyListData("محمد بعتلك سند من قبض عيني", "منذ 3 ساعات"),

        };
        MyListAdapter adapter = new MyListAdapter(myListData);
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





