package com.example.mohammad_es_faz4_gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Account;
import com.example.mohammad_es_faz4_gui.BackEnd.Buildings.Bank.Transaction;
import com.example.mohammad_es_faz4_gui.BackEnd.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FinancialManagementActivity extends AppCompatActivity {

    private Context thisContext;
    boolean stop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_management);
        Objects.requireNonNull(getSupportActionBar()).hide();
        thisContext = this;
        Country.setTransactionsShown(true);

        List<String> transactionList =  new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_list_item_1, transactionList);
        Account.getLiveTransactions().clear();

        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                String item;
                ListView listItems = findViewById(R.id.financialManagementList);
                adapter.clear();
                if (Account.getLiveTransactions().size() >= 9)
                    Account.getLiveTransactions().remove(0);
                for (Transaction transaction: Account.getLiveTransactions()) {
                    item = "City : " + transaction.getAccount().getBank().getCity().getName() +
                            " - Bank : " + transaction.getAccount().getBank().getName() +
                            "\nUser : " + transaction.getAccount().getUsername() +
                            "\n" + transaction.toString();
                    adapter.add(item);
                }
                runOnUiThread(() -> {
                    listItems.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                });
                if (!stop)
                    handler.postDelayed(this, 1000);
            }
        };
        if (!stop)
            handler.postDelayed(r, 1000);
    }

    @Override
    public void onBackPressed(){
        stop = true;
        Country.setTransactionsShown(false);
        finish();
    }


}