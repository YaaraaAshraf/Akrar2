package com.example.akrar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Other_DocumentsCash extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinner, spi_deposite;
    Button btn_send;
    String[] pay_type = {"كاش", "اجل"};
    String[] deposite_type = {"نعم", "لا"};

    public Other_DocumentsCash() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_other__documents_cash, container, false);

        btn_send = (Button) view.findViewById(R.id.btn_send_to);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadpage(new salary_documents());
            }
        });
        spinner = (Spinner) view.findViewById(R.id.spinner_paytype);
        spi_deposite = (Spinner) view.findViewById(R.id.spinner_deposite);
        spinner.setOnItemSelectedListener(this);
        spi_deposite.setOnItemClickListener((AdapterView.OnItemClickListener) getActivity());
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, pay_type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        ArrayAdapter deposite = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, deposite_type);
        deposite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_deposite.setAdapter(deposite);
        return view;
    }
    private void loadpage(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), pay_type[i], Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
