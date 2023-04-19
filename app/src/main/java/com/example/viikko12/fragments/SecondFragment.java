package com.example.viikko12.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.viikko12.Purchase;
import com.example.viikko12.PurchaseStorage;
import com.example.viikko12.R;
import com.google.android.material.button.MaterialButton;


public class SecondFragment extends Fragment {

    EditText popupSetName, popupSetReminder;
    Button btnSavePurchase, btnCancel;
    Switch aSwitch;

    Boolean state = false;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        popupSetName = view.findViewById(R.id.EditTextName);
        popupSetReminder = view.findViewById(R.id.EditTextReminder);
        btnSavePurchase = view.findViewById(R.id.btnAddPurchase);
        aSwitch = view.findViewById(R.id.swtch);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                        state = true;
                } else {
                       state = false;
                }
            }
        });

        btnSavePurchase.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                Purchase purchase = new Purchase(popupSetName.getText().toString(),popupSetReminder.getText().toString(),state);
                PurchaseStorage.getInstance().addPurchase(purchase);
                Toast.makeText(getContext(),purchase.getName() + " lisätty ostoskoriin.",Toast.LENGTH_LONG).show();

                Bundle result = new Bundle();
                result.putString("bundleKey", "result");
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });


        return view;
    }
}