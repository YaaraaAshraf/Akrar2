package com.example.akrar;
import android.os.Bundle;

        import androidx.fragment.app.Fragment;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
public class BondCashFragment extends Fragment {
    ImageView image_add_bond_cash,arow;
    ImageView fab;
    public BondCashFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bond_cash_fragment, container, false);
        image_add_bond_cash=(ImageView)view.findViewById(R.id.image_add_bond_cash);
        fab=(ImageView) view.findViewById(R.id.floatingActionButton_cash);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomsheetDialogCash bottomsheetDialog=new BottomsheetDialogCash();
                bottomsheetDialog.show(getFragmentManager(),bottomsheetDialog.getTag());
            }
        });
        arow=(ImageView)view.findViewById(R.id.img_arrow);
        arow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(new Mainpage_details());
            }
        });
        image_add_bond_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadcashbond(new Other_DocumentsCash());
            }
        });
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
    private boolean loadcashbond(Fragment fragment) {
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

