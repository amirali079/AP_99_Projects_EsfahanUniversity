package com.example.mohammad_es_faz4_gui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Bank;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BanksFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BanksFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.fragment_banks, container, false);
        FloatingActionButton floatAddBankButton = view.findViewById(R.id.floatAddBanksButton);
        floatAddBankButton.setOnClickListener(v -> switchToAddBank());
        return view;
    }

    @Override
    public void onResume() {
        makeCitiesButton();
        super.onResume();
    }

    private void makeCitiesButton() {
        LinearLayout linearLayout = getView().findViewById(R.id.banksLinearView);
        for (int i = linearLayout.getChildCount(); i < CityActivity.city.getBanks().size(); i++) {
            Button bankButton = new Button(getContext());
            CitiesActivity.createButtonStyle(bankButton, CityActivity.city.getBanks().get(i).getName());
            int finalI = i;
            bankButton.setOnClickListener(v -> switchToBank(finalI));
            linearLayout.addView(bankButton);
        }
    }

    private void switchToBank(int bankIndex) {
        Intent switchActivityIntent = new Intent(getContext(), BankActivity.class);
        switchActivityIntent.putExtra("bankIndex", bankIndex);
        startActivity(switchActivityIntent);
    }

    private void switchToAddBank() {
        Intent myIntent = new Intent(getActivity().getApplicationContext(), AddBankActivity.class);
        getActivity().startActivity(myIntent);
    }
}