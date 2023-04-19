package com.example.viikko12.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viikko12.Purchase;
import com.example.viikko12.PurchaseStorage;
import com.example.viikko12.R;
import com.example.viikko12.RecyclerViewAdapter;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    PurchaseStorage purchases;
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {

            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                String result = bundle.getString("bundleKey");
                // Do something with the result
                purchases = PurchaseStorage.getInstance();
                recyclerView.setAdapter(new RecyclerViewAdapter(getContext(),purchases.getCurrentLutemons()));
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        purchases = PurchaseStorage.getInstance();


        recyclerView = view.findViewById(R.id.RecyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), purchases.getCurrentLutemons()));

        return view;
    }

}